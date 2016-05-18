var dnsds = angular.module('dnsds', ['ngResource', 'ngRoute', 'checklist-model']),
    dnsdsUrl = 'http://localhost:8080';


dnsds.controller('DnsRecordsController', ['$scope', '$http', function($scope, $http) {

    $http.get(dnsdsUrl + '/dnsrecords').then(function(response) {
        $scope.dnsrecords = response.data;
        console.log($scope.dnsrecords);
    }, function(error) {
        alert('Whooops! Something went wrong. Try it later.');
        console.log(error);
    });

}]);

// kiddish.controller('AddController', ['$scope', '$http', function($scope, $http) {
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
//     // Testing purposes only: prefill ID
//     // $scope.marekoveData.Data.amazon_id ='B00KFAGCUM'; // @todo: remove when finished testing
//
//     // passing age, categories, pictures, gender
//     // Note: Load this enums up front JUST ONCE and do not wait for the user to click button
//
//     $http.get(kiddishUrl + '/categories').then(function(response) {
//         $scope.marekoveData.Categories = response.data;
//     }, function(error) {
//         alert('Ask Marek');
//         console.log(error);
//     });
//
//     $http.get(kiddishUrl + '/age').then(function(response) {
//         $scope.marekoveData.Age = response.data;
//     }, function(error) {
//         alert('Ask Marek');
//         console.log(error);
//     });
//
//     $http.get(kiddishUrl + '/gender').then(function(response) {
//         $scope.marekoveData.Gender = response.data;
//     }, function(error) {
//         alert('Ask Marek');
//         console.log(error);
//     });
//
//     $scope.getData = function () {
//         if($scope.marekoveData.Data.amazon_id.length == 10) {
//             console.log($scope.marekoveData.Data.amazon_id);
//             console.log($scope.marekoveData.Data.amazon_id.length);
//         }
//         else {
//             console.log($scope.marekoveData.Data.amazon_id);
//             var url = $scope.marekoveData.Data.amazon_id;
//             m = url.match("/([A-Z0-9]{10})");
//             console.log(m);
//
//             $scope.marekoveData.amazon_id = m[1];
//             console.log($scope.marekoveData.Data.amazon_id);
//         }
//
//         $http.get(kiddishUrl + '/get-amazon-info/' + $scope.marekoveData.Data.amazon_id).then(function(response) {
//             var i, l;
//
//             // Reset Selected helper
//             resetData();
//
//             $scope.marekoveData.Data = response.data;
//
//             // Prepare empty
//             $scope.marekoveData.Data.profile = null;
//             $scope.marekoveData.Data.gender = null;
//             $scope.marekoveData.Data.ages = [];
//             $scope.marekoveData.Data.categories = [];
//
//             // Select all pictures by default
//             if ($scope.marekoveData.Data.pictures) {
//                 l = $scope.marekoveData.Data.pictures.length;
//
//                 if (l > 0) {
//                     // First as cover by default
//                     $scope.marekoveData.Data.profile = $scope.marekoveData.Data.pictures[0];
//
//                     // than select all pictures
//                     for (i = 0; i < l; i++) {
//                         $scope.marekoveData.Selected.pictures.push(true);
//                     }
//                 }
//             }
//         }, function(error) {
//             alert('Put the right ASIN or URL or ask Marek');
//         });
//     };
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