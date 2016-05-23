var App = angular.module('myApp',["checklist-model"]);

//---------------
app.controller('Ctrl6', function($scope) {
        $scope.users = [
                {id: 1, name: 'Aaron'},
                {id: 2, name: 'David'},
                {id: 3, name: 'Moses'}
        ];

        $scope.selectedUsers = [];

        $scope.compareFn = function(obj1, obj2){
                return obj1.id === obj2.id;
        };
});
//---------------

App.directive('nxEqual', function() {
        return {
                require: 'ngModel',
                link: function (scope, elem, attrs, model) {
                        if (!attrs.nxEqual) {
                                console.error('nxEqual expects a model as an argument!');
                                return;
                        }
                        scope.$watch(attrs.nxEqual, function (value) {
                                model.$setValidity('nxEqual', value === model.$viewValue);
                        });
                        model.$parsers.push(function (value) {
                                var isValid = value === scope.$eval(attrs.nxEqual);
                                model.$setValidity('nxEqual', isValid);
                                return isValid ? value : undefined;
                        });
                }
        };
});