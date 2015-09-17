(function(){var aplicacionMundial= angular.module('aplicacionTbc',[]);
aplicacionMundial.directive('toolbar', function(){
        return{
            restrict:'E',
            templateUrl: 'partials/toolbar.html',
            controller:function(){
                this.tab=0;
                this.selectTab=function(setTab){
                    this.tab=setTab;
                };
                this.isSelected=function(tabParam){
                    return this.tab===tabParam;
                };
            
            
            
            
            },
            controllerAs:'toolbar'
            
            
            
            
            
            
        };
    });

    aplicacionMundial.directive('vcubInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/vcub-info.html',
            controller: 'getVcubs'
        };
    });
    
    aplicacionMundial.controller("getVcubs", function($http, $scope) {
    $http.get('http://localhost:8080/vcub/get').
      success(function(data, status, headers, config) {
        $scope.vcubs = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
    
    aplicacionMundial.directive('vcubForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/vcub-form.html',
            controller: 'vcubCtrl'
        };
    });
    
    aplicacionMundial.controller("vcubCtrl", function($http, $scope) {
 
        $scope.addVcub=function(){
            console.log('estado');
            $http.post('http://localhost:8080/vcub/add', JSON.stringify($scope.vcub)).success(function(data,headers){
                $scope.vcub={};
                $scope.toolbar.selectTab(5);
            });
        };
    });    
    
    
    
    aplicacionMundial.directive('ubicacionInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/ubicacion-info.html',
            controller: 'getUbicaciones'
        };
    });
    
    aplicacionMundial.controller("getUbicaciones", function($http, $scope) {
    $http.get('http://localhost:8080/ubicacion/get').
      success(function(data, status, headers, config) {
        $scope.ubicaciones = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
    
    aplicacionMundial.directive('ubicacionForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/ubicacion-form.html',
            controller: 'ubicacionCtrl'
        };
    });
    
    aplicacionMundial.controller("ubicacionCtrl", function($http, $scope) {
 
        $scope.addUbicacion=function(){
            console.log('latitud');
            $http.post('http://localhost:8080/ubicacion/add', JSON.stringify($scope.ubicacion)).success(function(data,headers){
                $scope.ubicacion={};
                $scope.toolbar.selectTab(7);
            });
        };
    });    
    
    aplicacionMundial.directive('rankingConductores', function(){
        return{
            restrict:'E',
            templateUrl:'partials/mejorConductor.html',
            controller: 'getRank'
        };
    });
    
    aplicacionMundial.controller("getRank", function($http, $scope) {
    $http.get('http://localhost:8080/conductor/rank').
      success(function(data, status, headers, config) {
        $scope.rank = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });

aplicacionMundial.directive('competitorInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/competitor-info.html',
            controller: 'getCompetitors'
        };
    });
 
    aplicacionMundial.controller("getCompetitors", function($http, $scope) {
    $http.get('http://localhost:8080/competitors/get').
      success(function(data, status, headers, config) {
        $scope.competitors = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
   
    aplicacionMundial.directive('competitorForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/competitor-form.html',
            controller: 'competitorCtrl'
        };
    });
    
   
    
    aplicacionMundial.controller("competitorCtrl", function($http, $scope) {
 
        $scope.addCompetitor=function(){
            console.log('name');
            $http.post('http://localhost:8080/competitors/add', JSON.stringify($scope.competitor)).success(function(data,headers){
                $scope.competitor={};
                $scope.toolbar.selectTab(2);
            });
        };
    }); 
    
    aplicacionMundial.directive('loginInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/login-info.html',
            controller: 'jesuslogin'
        };
    });
 
   aplicacionMundial.controller("jesuslogin", function($http, $scope) {
 
        $scope.competitors = $scope1;
     
    });
    
    var $scope1;

    
    
    
     aplicacionMundial.directive('loginForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/login-form.html',
            controller: 'loginCtrl'
        };
    });
    
    
    
    
    
    
    aplicacionMundial.controller("loginCtrl", function($http, $scope) {
 
 $scope.login=function(){
 $http.get('http://localhost:8080/competitors/login/emailUsr/' + $scope.login.email + '/passwordusr/' +$scope.login.password).             success(function(data, status, headers, config) {
        
     $scope.competitors = data;
     $scope1 = data;
        $scope.toolbar.selectTab(4);

      }).
      error(function(data, status, headers, config) {
        // log error
      });
    }});
    
    
    

} )



();

