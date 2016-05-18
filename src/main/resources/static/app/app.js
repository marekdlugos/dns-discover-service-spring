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