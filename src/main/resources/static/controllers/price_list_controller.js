app.controller("price_list_controller", function($scope,$http,$cookies,$location,$window,$controller){

    angular.extend(this, $controller('defaultController', {$scope: $scope}));

    $cookies.put('repositorium','price_list');
    $cookies.put('subObjectsOne',null);
    $cookies.put('subObjectsTwo',null);
    $cookies.put('subObjectsThree',null);
    $cookies.put('subObjectsFour',null);

    if($cookies.get('state')==null || $cookies.get('state')==""){
       $cookies.put('state','edit');
    }

      $scope.setObjects();

      $scope.obj={};
      $scope.state=$cookies.get('state');


     $scope.foo = function(event, obj) {
         $(".highlighted").removeClass("highlighted");
         $(event.currentTarget).addClass("highlighted");
         if($scope.state=="edit"){
             $scope.obj={};
             $scope.obj.price_list_id=$(event.currentTarget).find(".id").html();
             $scope.obj.valid_from=new Date($(event.currentTarget).find(".valid_from").html());

         }
      };


      $scope.sync = function(item){
          $scope.$apply(function() {
              if($scope.state=="edit"){
                  $scope.obj={};
                  $scope.obj.price_list_id=item.find(".id").html();
                  $scope.obj.valid_from=new Date(item.find(".valid_from").html());
              }
          });
       };

       $("#moPickup").off().on('click', function() {
           $scope.$apply(function() {
               console.log($scope.valid_from);
               console.log(new Date($scope.valid_from));
               console.log($scope.increase);
               if($scope.increase==true){
                    $scope.percent=100+$scope.percent;
               }else
                    $scope.percent=100-$scope.percent;
               console.log($scope.percent);
               $http.post('/'+$cookies.get('repositorium')+'/copyPriceList/'+$scope.obj.price_list_id+'/'+(new Date($scope.valid_from)).getTime()+'/'+$scope.percent)
                  .then(function(response){
                      alert("proslo");
                  });
               $('#modalOne').modal('toggle');
           });
       });
});