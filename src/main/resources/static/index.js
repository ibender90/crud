angular.module('students_app', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage){

    const path = 'http://localhost:9090/api/v1/students';

    $scope.loadStudents = function() {
        $http.get(path)
            .then(function (response){
                    $scope.students = response.data;
                }).catch(angular.noop);
    };

    $scope.getStudent = function(studentId) {
        $http.get(path + "/" + studentId)
            .then(function(response){
                       $scope.studentToEdit = response.data;
                    }).catch(angular.noop);
                };

    $scope.deleteStudent = function (studentId) {
        $http.delete(path + "/" + studentId)
            .then(function (response){
                $scope.loadStudents();
        });
    };

    $scope.addNewStudent = function(newStudent){
        $http.post(path, $scope.newStudent)
            .then(function (response){
                $scope.loadStudents();
        });
    };

    $scope.editStudent = function(studentToEdit){
            $http.patch(path, $scope.studentToEdit)
                .then(function (response){
                    $scope.loadStudents();
            });
        };

    $scope.loadStudents();
});