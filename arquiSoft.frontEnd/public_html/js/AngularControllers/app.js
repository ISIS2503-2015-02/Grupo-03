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
    
    aplicacionMundial.directive('mejorConductor', function(){
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

 $http.get('http://localhost:8080/login/login/idUsr/' + $scope.usuarios.username + '/pass/' + $scope.usuarios.password ).success(function(data,headers){

    $scope.reload = function()
{
   location.reload(); 
}
        $scope.userRole = 'administrador';

     $scope.reload();

      $scope.toolbar.selectTab(1);


   

            });

    }});
    
    
    
    


    
    
    aplicacionMundial.directive('tranviaInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/tranvia-info.html',
            controller: 'getTranvias'
        };
    });
    
    aplicacionMundial.controller("getTranvias", function($http, $scope) {
    $http.get('http://localhost:8080/tranvia/tranvias').
      success(function(data, status, headers, config) {
        $scope.tranvias = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
    aplicacionMundial.directive('tranviaForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/tranvia-form.html',
            controller: 'tranviaCtrl'
        };
    });
    aplicacionMundial.controller("tranviaCtrl", function($http, $scope) {
 
        $scope.addTranvia=function(){
            $http.post('http://localhost:8080/tranvia/add', JSON.stringify($scope.tranvia)).success(function(data,headers){
                $scope.tranvia={};
                $scope.toolbar.selectTab(8);
            });
        };
     }); 
     
     
     
  
    aplicacionMundial.directive('usuarioInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/usuario-info.html',
            controller: 'getUsuarios'
        };
    });
    
    aplicacionMundial.controller("getUsuarios", function($http, $scope) {
    $http.get('http://localhost:8080/usuario/usuarios').
      success(function(data, status, headers, config) {
        $scope.usuarios = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
  
    aplicacionMundial.directive('usuarioForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/usuario-form.html',
            controller: 'usuarioCtrl'
        };
    });
    aplicacionMundial.controller("usuarioCtrl", function($http, $scope) {
 
        $scope.addUsuario=function(){
            $http.post('http://localhost:8080/usuario/add', JSON.stringify($scope.usuario)).success(function(data,headers){
                $scope.usuario={};
                $scope.toolbar.selectTab(10);
            });
        };
          
    });
    
    

    
    
     aplicacionMundial.directive('mobibusInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/mobibus-info.html',
            controller: 'getMobibuses'
        };
    });
    
    aplicacionMundial.controller("getMobibuses", function($http, $scope) {
    $http.get('http://localhost:8080/mobibus/get').
      success(function(data, status, headers, config) {
        $scope.mobibus = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
    
    
   aplicacionMundial.directive('mobibusForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/mobibus-form.html',
            controller: 'mobibusCtrl'
        };
    });
    
    aplicacionMundial.controller("mobibusCtrl", function($http, $scope) {
 
        $scope.addMobibus=function(){
            console.log('id');
            $http.post('http://localhost:8080/mobibus/add', JSON.stringify($scope.mobibus)).success(function(data,headers){
                $scope.mobibus={};
                $scope.toolbar.selectTab(3);
            });
        };
    });    
    
    
    aplicacionMundial.directive('reservaInfo', function(){
        return{
            restrict:'E',
            templateUrl:'partials/reserva-info.html',
            controller: 'getReservas'
        };
    });
    
    
    aplicacionMundial.controller("getReservas", function($http, $scope) {
    $http.get('http://localhost:8080/reserva/reservas').
      success(function(data, status, headers, config) {
        $scope.reservas = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });
    aplicacionMundial.directive('reservaForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/reserva-form.html',
            controller: 'reservaCtrl'
        };
    });
    aplicacionMundial.controller("reservaCtrl", function($http, $scope) {

        $scope.reservar=function(){
            $http.put('http://localhost:8080/usuario/reservar/idUsr/'+ $scope.reserva.id + '/idMobibus/' + $scope.reserva.idM + '/fecha/' + $scope.reserva.fecha , '').success(function(data,headers){
                $scope.reserva={};
                $scope.toolbar.selectTab(15);
            });
        };
     }); 
    
    
    
    
    
    

    
    
    aplicacionMundial.directive('alquilarForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/alquilar-form.html',
            controller: 'alquilarCtrl'
        };
    });
    aplicacionMundial.controller("alquilarCtrl", function($http, $scope) {

        $scope.alquilar=function(){
            $http.put('http://localhost:8080/usuario/alquilar/idUsr/'+ $scope.alquiler.id + '/idVcub/'+$scope.alquiler.idVcub,'').success(function(data,headers){
                $scope.toolbar.selectTab(10);
            });
        };
     });
    

        aplicacionMundial.directive('devolverForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/devolver-form.html',
            controller: 'devolverCtrl'
        };
    });
    aplicacionMundial.controller("devolverCtrl", function($http, $scope) {

        $scope.devolver=function(){
            $http.put('http://localhost:8080/usuario/devolver/idUsr/'+ $scope.devolver.id+ '/idVcub/'+$scope.devolver.idV, '').success(function(data,headers){
                $scope.toolbar.selectTab(10);
            });
        };
     });
    
    
    aplicacionMundial.directive('addconductorForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/addconductor-form.html',
            controller: 'addconductorCtrl'
        };
    });
    aplicacionMundial.controller("addconductorCtrl", function($http, $scope) {

        $scope.addConductor=function(){
            $http.put('http://localhost:8080/conductor/add', JSON.stringify($scope.conductor)).success(function(data,headers){
                $scope.conductor={};
                $scope.toolbar.selectTab(13);
            });
        };
    });
    
    
      aplicacionMundial.directive('cancelarForm', function(){
        return{
            restrict:'E',
            templateUrl:'partials/cancelar-form.html',
            controller: 'cancelarCtrl'
        };
    });
    aplicacionMundial.controller("cancelarCtrl", function($http, $scope) {

        $scope.cancelar=function(){
            $http.put('http://localhost:8080/usuario/cancelar/idReserva/'+ $scope.cancelar.id , '').success(function(data,headers){
                $scope.toolbar.selectTab(15);
            });
        };
     });
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

} )



();

