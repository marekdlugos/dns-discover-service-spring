App.controller('UserController', ['$rootScope', '$scope', 'UserService', function($rootScope, $scope, UserService) {
    var self = this;
    self.userIsAdmin = $rootScope.currentUser.roles.authority === 'ADMIN';
    self.user={id:null, name:'', email:'', password:''};
    self.users=[];
    self.editable = false;

    self.fetchAllUsers = function(){
        UserService.fetchAllUsers()
            .then(
                function(d) {
                    self.users = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies' + errResponse);
                }
            );
    };

    self.createUser = function(user){
        var data = {
            id: user.id,
            name: user.name,
            email: user.email,
            password: user.password
        };
        UserService.createUser(data)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while creating User.' + errResponse);
                }
            );
    };

    self.updateUser = function(user, id){
        var data = {
            name: user.name,
            email: user.email,
            password: user.password
        };
        UserService.updateUser(data, id)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while updating User.' + errResponse);
                }
            );
    };

    self.deleteUser = function(id){
        UserService.deleteUser(id)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while deleting User.'+errResponse);
                }
            );
    };

    self.fetchAllUsers();

    self.submit = function() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            self.createUser(self.user);
        }else{
            self.updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
            }
            self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
        self.editable = true;
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        self.deleteUser(id);
    };


    self.reset = function(){
        self.user={id:null, name:'',email:'', password:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}])

.controller('RecordsController', ['$rootScope', '$scope', 'RecordService', function($rootScope, $scope, RecordService) {
    var self = this;
    self.userIsAdmin = $rootScope.currentUser.roles.authority === 'ADMIN';
    self.record={
        id: '',
        zone: '',
        host: '',
        ttl: '',
        type: '',
        mx_priority: '',
        data: '',
        resp_person: '',
        serial: '',
        refresh: '',
        retry: '',
        expire: '',
        minimum: ''
    };
    self.records=[];
    self.editable = false;
    self.projectid = '';

    self.fetchAllRecords = function(){
        RecordService.fetchAllRecords()
            .then(
                function(d) {
                    self.records = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies' + errResponse);
                }
            );
    };

    self.createRecord = function(record, projectid){

        RecordService.createRecord(record, projectid)
            .then(
                function(response) { window.location.replace('records.html'); },
                function(errResponse){
                    console.error('Error while creating record.' + errResponse);
                }
            );
    };

    self.updateRecord = function(record, recordid, projectid){

        RecordService.updateRecord(record, recordid, projectid)
            .then(
                function(response) { window.location.replace('records.html'); },
                function(errResponse){
                    console.error('Error while updating record.' + errResponse);
                }
            );
    };

    self.deleteRecord = function(id){
        RecordService.deleteRecord(id)
            .then(
                self.fetchAllRecords,
                function(errResponse){
                    console.error('Error while deleting record.'+errResponse);
                }
            );
    };

    self.fetchAllRecords();

    self.submitForm = function() {
        if(self.record.id===''){
            console.log('Saving New record', self.record);
            self.createRecord(self.record, self.projectid);
        }else{
            self.updateRecord(self.record, self.record.id, self.projectid);
            console.log('record updated with id ', self.record.id);
        }
        self.reset();
        self.projectid = '';
        self.editable = false;
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.records.length; i++){
            if(self.records[i].id === id) {
                self.record = angular.copy(self.records[i]);
                break;
            }
        }
        self.editable = true;
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.record.id === id) {//clean form if the record to be deleted is shown there.
            self.reset();
        }
        self.deleteRecord(id);
    };


    self.reset = function(){
        self.record={
            id: '',
            zone: '',
            host: '',
            ttl: '',
            type: '',
            mx_priority: '',
            data: '',
            resp_person: '',
            serial: '',
            refresh: '',
            retry: '',
            expire: '',
            minimum: ''
        };
        $scope.myForm.$setPristine(); //reset Form
    };

}])

.controller('ProjectsController', ['$rootScope', '$scope', 'ProjectService', 'UserService', 'ParticipationService',  function($rootScope, $scope, ProjectService, UserService, ParticipationService) {
    var self = this;
    self.userIsAdmin = $rootScope.currentUser.roles.authority === 'ADMIN';
    self.project={
        id: '',
        name: '',
        description: ''
    };
    self.participation={
        userID: '',
        projectID: '',
        permission: {
            id: '',
            name: '',
        }
    };
    self.projects=[];
    self.editable = false;

    self.canEditProject = function(projectId) {
        if (self.userIsAdmin) {
            return true;
        } else {
            return $rootScope.currentUser.participations.some(function(project) {
                return (project.projectID === projectId && (project.permissions.name === "EDIT" || project.permissions.name === "ADMIN"));
            });
        }
    };

    self.canRemoveProject = function(projectId) {
        if (self.userIsAdmin) {
            return true;
        } else {
            return $rootScope.currentUser.participations.some(function(project) {
                return (project.projectID === projectId && project.permissions.name === "ADMIN");
            });
        }
    };

    self.permissions = [{
        id: 1,
        name: 'VIEW'
    }, {
        id: 2,
        name: 'EDIT'
    }, {
        id: 3,
        name: 'ADMIN'
    }];

    UserService.fetchAllUsers()
        .then(
            function(d) {
                self.users = d;
                self.usersWithPermissions = d.map(function(user) {
                    return {
                        user: user,
                        permission: self.permissions[0]
                    };
                });
            },
            function(errResponse){
                console.error('Error while fetching Currencies' + errResponse);
            }
        );


    $scope.selectedUsers = [ 1, 2 ]; // here add userID + projectID

    //console.log($scope.users);

    self.fetchAllProjects = function(){
        ProjectService.fetchAllProjects()
            .then(
                function(d) {
                    self.projects = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies', errResponse);
                }
            );
    };

    self.createProject = function(record){

        ProjectService.createProject(record)
            .then(
                function(response) {
                    ParticipationService.saveParticipation({
                        'participations': [
                            {
                                'projectID': response.project.id,
                                'userID': 1,
                                'permissions': {
                                    'id': 3,
                                    'name': 'ADMIN'
                                }
                            }, {
                                'projectID': response.project.id,
                                'userID': 2,
                                'permissions': {
                                    'id': 2,
                                    'name': 'EDIT'
                                }
                            }
                        ]
                    });
                },
                function(errResponse){
                    console.error('Error while creating project.', errResponse);
                }
            );
    };

    self.updateProject = function(record, id){

        ProjectService.updateProject(record, id)
            .then(
                function(response) {
                    ParticipationService.saveParticipation
                },
                function(errResponse){
                    console.error('Error while updating project.',  errResponse);
                }
            );
    };

    self.deleteProject = function(id){
        ProjectService.deleteProject(id)
            .then(
                self.fetchAllProjects,
                function(errResponse){
                    console.error('Error while deleting project.', errResponse);
                }
            );
    };

    self.fetchAllProjects();

    self.submit = function() {
        if(self.project.id===''){
            console.log('Saving New project', self.project);
            self.createProject(self.project);
        }else{
            self.updateProject(self.project, self.project.id);
            console.log('Project updated with id ', self.project.id);
        }
        self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.projects.length; i++){
            if(self.projects[i].id === id) {
                self.project = angular.copy(self.projects[i]);
                break;
            }
        }
        self.editable = true;
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.project.id === id) {//clean form if the record to be deleted is shown there.
            self.reset();
        }
        self.deleteProject(id);
    };


    self.reset = function(){
        self.project={
            id: '',
            name: '',
            description: ''
        };
        $scope.myForm.$setPristine(); //reset Form
    };
    self.projectName = function (projectID) {
        for(var i = 0; i < self.projects.length; i++){
            if(self.projects[i].id === projectID) {
                return self.projects[i].name;
            }
        }
    }

}])

.controller('RoleController', ['$rootScope', '$scope', 'RoleService',  function($rootScope, $scope, RoleService) {
    var self = this;
    self.userIsAdmin = $rootScope.currentUser.roles.authority === 'ADMIN';
    self.role={
        id: '',
        name: '',
        description: ''
    };
    self.roles=[];

    self.fetchAllRoles = function(){
        RoleService.fetchAllRoles()
            .then(
                function(d) {
                    self.roles = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies', errResponse);
                }
            );
    };
    self.fetchAllRoles();
}]);
