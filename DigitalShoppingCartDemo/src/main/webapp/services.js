/**
 * 
 */
var services=angular.module('RestfulWebServices.services',['ngResource']);
services.factory('UserFactory',function($resource)
		{
			return $resource('/RestfulWebServices/webresources/ResourceForAll',{},{
				query:{
					method:'GET',
					params:{},
					isArray:false
				}
			})
		});