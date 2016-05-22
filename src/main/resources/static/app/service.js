App.factory('UserService', ['$http', '$q', function($http, $q){

    return {

        fetchAllUsers: function() {
            return $http.get('http://localhost:8888/users')
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
            return $http.post('http://localhost:8888/users', user)
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
            return $http.put('http://localhost:8888/users/'+id, user)
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
            return $http.delete('http://localhost:8888/users/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting user');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}])

.factory('RecordService', ['$http', '$q', function($http, $q){

    return {

        fetchAllRecords: function() {
            return $http.get('http://localhost:8888/dnsrecords')
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

        createRecord: function(user){
            return $http.post('http://localhost:8888/dnsrecords', user)
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

        updateRecord: function(user, id){
            return $http.put('http://localhost:8888/dnsrecords/'+id, user)
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

        deleteRecord: function(id){
            return $http.delete('http://localhost:8888/dnsrecords/'+id)
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
            return $http.get('http://localhost:8888/projects')
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
            return $http.post('http://localhost:8888/projects', user)
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
            return $http.put('http://localhost:8888/projects/'+id, user)
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
            return $http.delete('http://localhost:8888/projects/'+id)
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

}]);