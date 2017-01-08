App.factory('UserService', ['$http', '$q', function($http, $q){

    return {

        fetchAllUsers: function() {
            return $http.get('http://localhost:8080/users')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        },

        createUser: function(user){
            return $http.post('http://localhost:8080/users', user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateUser: function(user, id){
            return $http.put('http://localhost:8080/users/'+id, user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating user');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteUser: function(id){
            return $http.delete('http://localhost:8080/users/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting user');
                        return $q.reject(errResponse);
                    }
                );
        },

        getCurrentUser: function(){
            return $http.get('http://localhost:8080/principal')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching current user');
                        return $q.reject(errResponse);
                    }
                )
        }

    };

}])

.factory('RecordService', ['$http', '$q', function($http, $q){

    return {

        fetchAllRecords: function() {
            return $http.get('http://localhost:8080/dnsrecords')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching records');
                        return $q.reject(errResponse);
                    }
                );
        },

        createRecord: function(user, projectid){
            return $http.post('http://localhost:8080/dnsrecords'+projectid, user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating record');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateRecord: function(user, recordid, projectid){
            return $http.put('http://localhost:8080/dnsrecords/'+recordid+'/project/'+projectid, user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating record');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteRecord: function(id){
            return $http.delete('http://localhost:8080/dnsrecords/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting records');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}])

.factory('ProjectService', ['$http', '$q', function($http, $q){

    return {

        fetchAllProjects: function() {
            return $http.get('http://localhost:8080/projects')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching projects');
                        return $q.reject(errResponse);
                    }
                );
        },

        createProject: function(user){
            return $http.post('http://localhost:8080/projects', user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating project');
                        return $q.reject(errResponse);
                    }
                );
        },
        // save -> list {accountID, projectID, proleID}
        createProject2: function(user){
            return $http.post('http://localhost:8080/save', user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating project');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateProject: function(user, id){
            return $http.put('http://localhost:8080/projects/'+id, user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating project');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteProject: function(id){
            return $http.delete('http://localhost:8080/projects/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting project');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}])

.factory('RoleService', ['$http', '$q', function($http, $q){

        return {

            fetchAllRoles: function () {
                return $http.get('http://localhost:8080/roles')
                    .then(
                        function (response) {
                            return response.data;
                        },
                        function (errResponse) {
                            console.error('Error while fetching roles');
                            return $q.reject(errResponse);
                        }
                    );
            }
        }

    }])
    .factory('ParticipationService', ['$http', '$q', function($http, $q){
        return {
            saveParticipation: function (data) {
                return $http.post('http://localhost:8080/participation', data)
                    .then(
                        function (response) {
                            return response.data;
                        },
                        function (errResponse) {
                            console.error('Error while fetching roles');
                            return $q.reject(errResponse);
                        }
                    );
            }
        }
    }]);
