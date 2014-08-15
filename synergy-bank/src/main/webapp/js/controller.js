
angular.module('customerDeleteApp', []).factory('SomeCache', function($cacheFactory) {
    return $cacheFactory('someCache', {
        capacity: 3 // optional - turns the cache into LRU cache
    });
});


//var customerDeleteApp = angular.module('customerDeleteApp', []);
//var customerDeleteApp.controller('customerDeleteController', function($scope,$http,SomeCache) {
var customerDeleteController = function($scope,$http, SomeCache) {
  
	$scope.deleteCustomerRecord = function() {
		var uid =document.getElementById("currentUserId").innerHTML;
    	alert("it works___ and user id ="+uid);
    
    	var deleteURL = ccontextPath+"/deleteCustomer?userId="+uid;
		
    	$http({method: 'GET', url: "'"+deleteURL+"'"}).
        success(function(data, status, headers, config) {
          // this callback will be called asynchronously
          // when the response is available
        	alert("item deleted");
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        	alert("there is some error in deletion");
        });
    	/*    	var puserId = $scope.suserId;
    	  var iurl="profileImageByUserId.htm?userId="+puserId;
    	  //alert(iurl);
          $scope.uimage=iurl;
         $scope.result = result;
        $scope.status = status;
        $scope.cacheInfo = SomeCache.info(); 
       // create a user Object
        $scope.profile = {};
        // Initiate a model as an empty string
        // We want to make a call and get
        // the person's username
        var result = SomeCache.get(puserId);
        var durl=ccontextPath+"/jsonProfileAng.htm?userid="+puserId;
        var   status = 'pulled from cache';
         if (!result) {
            status = 'data is not present into the cache now';
        $http({
          method: 'GET',
          url: durl
        })
        .success(function (data, status, headers, config) {
          // See here, we are now assigning this username
          // to our existing model!
           SomeCache.put(puserId, data);
           //      
           $scope.profile.email=data.profile.email;
           $scope.profile.userid=data.profile.userid;
           $scope.profile.password=data.profile.password;
           $scope.profile.gender=data.profile.gender;
           $scope.profile.mobile=data.profile.mobile;
           $scope.profile.address=data.profile.address;
        	//alert("it works_22__"+data.profile.email);
        })
        .error(function (data, status, headers, config) {
          // something went wrong :(
        		  //alert(data);
        });
      } //end of the cache   
      else{
    	  alert("Data is coming from cache , thanks");
    	  var cacheData = SomeCache.get(puserId);
    	   var iurl="profileImageByUserId.htm?userId="+puserId;
          $scope.image.path=iurl; 
    	  $scope.profile.email=cacheData.profile.email;
          $scope.profile.userid=cacheData.profile.userid;
          $scope.profile.password=cacheData.profile.password;
          $scope.profile.gender=cacheData.profile.gender;
          $scope.profile.mobile=cacheData.profile.mobile;
          $scope.profile.address=cacheData.profile.address;
      }
    } //end of search profile
    $scope.clearCache = function() {
        SomeCache.removeAll();
        //$scope.cacheInfo = SomeCache.info();
    }
*/}}