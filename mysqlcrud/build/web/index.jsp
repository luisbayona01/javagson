<%-- 
    Document   : registrarusuarios
    Created on : 21/05/2018, 03:37:14 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script> 
   var app = angular.module("myapp", []);
  app.controller("myCtrl", function($scope,$http) {
     $scope.usuarios=function(){
	 var url     = "crearusuario";
	 var parametros = $.param({procesar: '0'});
	$http({
	  method  : 'POST',
	  url     : url,
	  data    : parametros, //this.formData,  // pass in data as strings
          headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).success(function(response){
	
       // console.log(response);
   $scope.usuer=response["datos"];   
	  });

}

$scope.Saveuser= function(){
  
	 var url     = "crearusuario";
	 var parametros = $("#form-usuarios").serialize();
	$http({
	  method  : 'POST',
	  url     : url,
	  data    : parametros, //this.formData,  // pass in data as strings
          headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).success(function(response){
	
        alert(response);
          $scope.usuarios();  
   //$scope.usuer=response["datos"];   
	  });


    
}
$scope.eliminar=function(idusuario){
  var url     = "crearusuario"
  var parametros = $.param({procesar: '2','idsusario':idusuario});; 
 $http({
	  method  : 'POST',
	  url     : url,
	  data    : parametros, //this.formData,  // pass in data as strings
          headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).success(function(response){
	
        alert(response);
          $scope.usuarios();  
   //$scope.usuer=response["datos"];   
	  });
 
       }
       
   
  $scope.traerdta= function(idusuario){
      var url="crearusuario";
      var parametros = $.param({procesar: '3','idsusario':idusuario});; 
      
      
  }     
        
       


 $scope.usuarios();
    });
    
    </script>


        <title>crud</title>
    </head>
    <body ng-app="myapp" ng-controller="myCtrl"> 
        
        <div class="container">
         
            <button class="btn btn-info" data-toggle="modal" data-target="#exampleModal" >Agregrar Usuarios</button>
          
            <table class="table table-bordered">
            <thead>
            <th>id </th>  
             <th>nmbre </th>
            <th>apellido </th>
              <th>edad </th>
              <th>Modificar</th>
              <th>Eliminar</th>
                  </thead> 
                  <tbody>
                      <tr ng-repeat="x in usuer">    
                  <td>{{x.idusuario}}</td>
                  <td>{{x.nombre}} </td>
                  <td>{{x.apellido}}</td>
                  <td>{{x.edad}}</td>
                  <td><button type="button" ng-click="traerdta(x.idusuario)" class="btn btn-warning">Editar</button>   </td>
                  <td><button type="button" ng-click="eliminar(x.idusuario)" class="btn btn-danger">Eliminar</button> </td>
                   </tr>   
                  </tbody>
            
        </table>   
        
        </div>
        
        
   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro  De  usuarios</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    <form id="form-usuarios">
   <div class="form-group row">
      <input type="hidden" name="procesar" value="1"> 
    <label for="inputEmail3" class="col-sm-2 col-form-label">Nombres</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="Nombres" placeholder="Nombres">
    </div>
   </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Apellidos</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="Apellidos"id="inputPassword3" placeholder="Apellidos">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3"  class="col-sm-2 col-form-label">Edad</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="Edad" id="inputPassword3" placeholder="Edad">
    </div>
  </div>
</form>  
          
</div>
      <div class="modal-footer">
          <button type="button" class="btn btn-primary" ng-click="Saveuser()">Guardar</button>
      </div>
    </div>
  </div>
</div>   
        
        
        
  
        
    <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro  De  usuarios</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
    <form id="update-usuarios">
        <div>    
   <div class="form-group row">
      <input type="hidden" name="procesar" value="3"> 
    <label for="inputEmail3" class="col-sm-2 col-form-label">Nombres</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="Nombres" placeholder="Nombres" value="">
    </div>
   </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Apellidos</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="Apellidos"id="inputPassword3" value="" placeholder="Apellidos">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3"  class="col-sm-2 col-form-label">Edad</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="Edad" id="inputPassword3" placeholder="Edad">
    </div>
  </div>
</form>  
          
</div>
       </div> 
      <div class="modal-footer">
          <button type="button" class="btn btn-primary" ng-click="Saveuser()">Guardar</button>
      </div>
    </div>
  </div>
</div>   
        
        
        
        
        
        
        
    </body>
</html>
    