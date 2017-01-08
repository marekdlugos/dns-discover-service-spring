var App = angular.module('myApp',["checklist-model"]);

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


(function() {
        var initInjector = angular.injector(['ng']);
        var $http = initInjector.get('$http');
        $http.get('http://localhost:8080/principal')
                .then(
                        function (currentUserResponse) {
                                App.run(function($rootScope) {
                                        $rootScope.currentUser = currentUserResponse.data;
                                });

                                angular.element(document).ready(function() {
                                        angular.bootstrap(document, ['myApp']);
                                });
                        }
                );
})();
