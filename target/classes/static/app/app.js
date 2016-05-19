var dnsds = angular.module('dnsds', ['ngResource', 'ngRoute', 'checklist-model']),
    dnsdsUrl = 'http://localhost:8888';


dnsds.controller('ProjectController', ['$scope', '$http', function($scope, $http) {

    $http.get(dnsdsUrl + '/projects').then(function(response) {
        $scope.projects = response.data;
        console.log($scope.projects);
    }, function(error) {
        alert('Whooops! Something went wrong. Try it later.');
        console.log(error);
    });

    $scope.name = '';
    $scope.description = '';


    $scope.newProject = function(){

        var data = angular.copy($scope.name, $scope.description);

        $http.post(dnsdsUrl + '/projects', data)
            .success(function(data, status, headers, config) {
                //console.log(data + status + headers + config);
                alert('Project was added.');
            })
            .error(function(data, status, headers, config) {
                //console.log(data + status + headers + config);
                alert('Failed to add project. Ask Marek!');
            });
    }
    
}]);

dnsds.controller('UserController', ['$scope', '$http', function($scope, $http) {

    $http.get(dnsdsUrl + '/users').then(function(response) {
        $scope.users = response.data;
        console.log($scope.users);
    }, function(error) {
        alert('Whooops! Something went wrong. Try it later.');
        console.log(error);
    });


    $scope.name = '';
    $scope.email = '';
    $scope.passw1 = '';
    $scope.passw2 = '';


    $scope.newUser = function(){

        var data = angular.copy($scope.name, $scope.email, $scope.passw1);

        $http.post(dnsdsUrl + '/users', data)
            .success(function(data, status, headers, config) {
                //console.log(data + status + headers + config);
                alert('User was added.');

            })
            .error(function(data, status, headers, config) {
                //console.log(data + status + headers + config);
                alert('Failed to add user. Ask Marek!');
            });
    }

    $scope.$watch('passw1',function() {$scope.test();});
    $scope.$watch('passw2',function() {$scope.test();});

    $scope.test = function() {
        if ($scope.passw1 !== $scope.passw2) {
            $scope.error = true;
        } else {
            $scope.error = false;
        }
    };
}]);


dnsds.controller('DnsRecordsController', ['$scope', '$http', function($scope, $http) {

    $http.get(dnsdsUrl + '/dnsrecords').then(function(response) {
        $scope.dnsrecords = response.data;
        console.log($scope.dnsrecords);
    }, function(error) {
        alert('Whooops! Something went wrong. Try it later.');
        console.log(error);
    });

    function resetData() {
        $scope.dnsrecords = {
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
            minimum: '',
        };
    }

    $scope.newDnsRecord = function(){

        var data = angular.copy($scope.dnsrecords);

        $http.post(dnsdsUrl + '/dnsrecords', data)
            .success(function(data, status, headers, config) {
                //console.log(data + status + headers + config);
                alert('record was added.');
                // Reset helper
                resetData();
            })
            .error(function(data, status, headers, config) {
                //console.log(data + status + headers + config);
                alert('Failed to add record. Ask Marek!');
            });
    }

}]);


// // Record Controller
//
// dnsds.controller('DnsRecordsController', ['$scope', '$http', function($scope, $http) {
//
//     $http.get(dnsdsUrl + '/dnsrecords').then(function(response) {
//         $scope.dnsrecords = response.data;
//         console.log($scope.dnsrecords);
//     }, function(error) {
//         alert('Whooops! Something went wrong. Try it later.');
//         console.log(error);
//     });
//
//     $scope.editRecord = function(id) {
//         if (id == 'new') {
//             $scope.edit = true;
//             $scope.incomplete = true;
//             $scope.zone = '';
//             $scope.mx_priority = '';
//             $scope.data = '';
//             $scope.resp_person = '';
//             $scope.serial = '';
//             $scope.refresh = '';
//             $scope.retry = '';
//             $scope.expire = '';
//             $scope.minimum = '';
//         } else {
//             $scope.edit = false;
//             $scope.incomplete = true;
//             $scope.zone = $scope.dnsrecords.zone[id-1].zone;
//             $scope.mx_priority = $scope.dnsrecords.mx_priority[id-1].mx_priority;
//             $scope.data = $scope.dnsrecords.data[id-1].data;
//             $scope.resp_person = $scope.dnsrecords.resp_person[id-1].resp_person;
//             $scope.serial = $scope.dnsrecords.serial[id-1].serial;
//             $scope.refresh = $scope.dnsrecords.refresh[id-1].refresh;
//             $scope.retry = $scope.dnsrecords.retry[id-1].retry;
//             $scope.expire = $scope.dnsrecords.expire[id-1].expire;
//             $scope.minimum = $scope.dnsrecords.minimum[id-1].minimum;
//             $scope.ttl = $scope.dnsrecords.ttl[id-1].ttl;
//         }
//     };
//
//     $scope.$watch('zone',function() {$scope.test();});
//     $scope.$watch('mx_priority',function() {$scope.test();});
//     $scope.$watch('data', function() {$scope.test();});
//     $scope.$watch('resp_person', function() {$scope.test();});
//     $scope.$watch('serial', function() {$scope.test();});
//     $scope.$watch('refresh', function() {$scope.test();});
//     $scope.$watch('retry', function() {$scope.test();});
//     $scope.$watch('expire', function() {$scope.test();});
//     $scope.$watch('minimum', function() {$scope.test();});
//     $scope.$watch('ttl', function() {$scope.test();});
//
//     //add validation if $scope.data is number
//
//     $scope.test = function() {
//         $scope.incomplete = false;
//         if ($scope.edit && (!$scope.zone.length ||
//             !$scope.mx_priority.length ||
//             !$scope.data.length || !$scope.resp_person.length || !$scope.serial.length
//             || !$scope.refresh.length || !$scope.retry.length || !$scope.expire.length
//             || !$scope.minimum.length || !$scope.ttl.length)) {
//             $scope.incomplete = true;
//         }
//     };
// }]);
//
//





// dnsds.controller('AddController', ['$scope', '$http', function($scope, $http) {
//
//     $scope.marekoveData = {
//         Categories: [],
//         Age: [],
//         Gender: [],
//         Data: {},
//         Selected: {}
//     };
//
//     // Init fresh data
//     function resetData() {
//         $scope.marekoveData.Data = {
//             amazon_id: '',
//             detail_url: '',
//             wishlist_url: '',
//             name: '',
//             price: '',
//             curators_note: '',
//             approved: 1,
//             gender: '',
//             added_by: 2,
//             pictures: {},
//             age: {},
//             categoryId: {}
//         };
//         $scope.marekoveData.Selected.pictures = [];
//     }
//
//     // Init Data
//     resetData();
//
//     $scope.ready = function () {
//         return $scope.marekoveData.Data.gender && $scope.marekoveData.Data.categories.length > 0 && $scope.marekoveData.Data.ages.length > 0;
//     }
//
//     $scope.save = function () {
//         var data = angular.copy($scope.marekoveData.Data),
//             i, l;
//
//         // remove all unselected pictures and copy them back if were selected
//         data.pictures = [];
//
//         l = $scope.marekoveData.Selected.pictures.length;
//
//         for (i = 0; i < l; i++) {
//             if ($scope.marekoveData.Selected.pictures[i]) {
//                 data.pictures.push($scope.marekoveData.Data.pictures[i]);
//             }
//         }
//
//         console.log(data);
//         $http.post(kiddishUrl + '/products', data)
//             .success(function(data, status, headers, config) {
//                 //console.log(data + status + headers + config);
//                 alert('Product was added.');
//                 // Reset helper
//                 resetData();
//             })
//             .error(function(data, status, headers, config) {
//                 //console.log(data + status + headers + config);
//                 alert('Failed to add product. Ask Marek!');
//             });
//     };
//
// }]);