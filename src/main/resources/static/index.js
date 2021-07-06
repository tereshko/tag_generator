angular.module('app', []).controller('indexPageController', function ($scope, $http) {
    const contextPath = 'http://localhost:8989/api/v1'

    $scope.tagsExisted = 0;

    $scope.filltable = function (tagsExisted) {
        return $http.get(contextPath + '/generator?tagsExisted=' + tagsExisted)
            .then(function (response) {

                $scope.Botanical = response.data.Botanical;
                $scope.General = response.data.General;
                $scope.Graphic = response.data.Graphic;
                $scope.Location = response.data.Location;
                $scope.Personal = response.data.Personal;

                var tags_array = new Array();

                for (var i=0; i<$scope.Botanical.length; i++) {
                    tags_array.push($scope.Botanical[i].tag)
                }

                for (var i=0; i<$scope.General.length; i++) {
                     tags_array.push($scope.General[i].tag)
                 }
                for (var i=0; i<$scope.Graphic.length; i++) {
                    tags_array.push($scope.Graphic[i].tag)
                }
                for (var i=0; i<$scope.Location.length; i++) {
                    tags_array.push($scope.Location[i].tag)
                }
                for (var i=0; i<$scope.Personal.length; i++) {
                    tags_array.push($scope.Personal[i].tag)
                }

                var str = "";

                for (element of tags_array) {
                    str = str + " #" + element;
                }

                console.log("функция: " + str);

                return str;

            });
    };

    $scope.copy_function = function() {
        /* Get the text field */
        var copyText = document.getElementById("tag_output");

        var userTextboxValue = copyText.value;
        if (userTextboxValue.length != 0) {
            var userTextAfterFormatting = userTextboxValue.split( "\n" ).join( " " ).split( " " );

            var tags_array = new Array();

            for (var i=0; i < userTextAfterFormatting.length; i++) {
                tags_array.push(userTextAfterFormatting[i])
            }

            var inputString = "";

            for (element of tags_array) {
                inputString = inputString + " #" + element;
            }
            console.log("моя строка:" + inputString);
        }

        var receiveFromServer = $scope.filltable(userTextAfterFormatting.length);
        
        receiveFromServer.then(function(endOfResult) {
        
            var obj = JSON.stringify(receiveFromServer); 

            for (let [key, value] of Object.entries(receiveFromServer)) {
                console.log(`${key}: ${value}`);
                var temp = Object.entries(value);
                temp = temp[2][1];
            }


            var output = inputString + "" +temp;
            console.log("все вместе: " + output);

            copyText.value = output;

            /* Select the text field */
            copyText.select();
            copyText.setSelectionRange(0, 99999); /* For mobile devices */

            /* Copy the text inside the text field */
            document.execCommand("copy");

            /* Alert the copied text */
            alert("Copied the text: " + copyText.value);
        });

    };


    /* $scope.filltable(); */

});