function isANumber(value) {
  if (typeof value == typeof "") {
    var num = parseInt(value);
    console.log("number catched: " + num);
    if (isNaN(num) || num == undefined) {
      return false;
    } else {
      return true;
    }
  }
  return typeof value == typeof(0);
}

function controllExceptions(array, num = undefined) {
    if (num != undefined && !isANumber(num)) {
      throw "is not a number";
    }
  
    if (!Array.isArray(array)) {
      throw "is not an array";
    }
  
    if (!arrayWithOnlyNumbers(array)) {
      throw "Array not contains only numbers";
    }
  }

function controllAndRunMethod(array, callback) {
  controllExceptions(array);
  callback();
}

function arrayWithOnlyNumbers(array) {
  for (var i = 0; i < array.length; i++) {
    if (!isANumber(array[i])) {
      return false;
    }
  }
  return true;
}

function cycleNumbers(array, callback) {
  for (var i = 0; i < array.length; i++) {
    callback(array[i]);
  }
}

  _formulePositive = (value) => value >= 0;
  _formuleEven = (value) => value % 2 == 0;
  formulePositiveValue = value => _formulePositive(value);
  formuleNegativeValue = value  => !_formulePositive(value);
  formuleEvenValue = value => _formuleEven(value);
  formuleOddValue = value => !_formuleEven(value);


function _max(number, myValue) {
  if(number >= myValue) {
   return number;
  }
  return myValue;
}

function _min(number, myValue) {
  if(number < myValue) {
   return number;
  }
  return myValue;
}
