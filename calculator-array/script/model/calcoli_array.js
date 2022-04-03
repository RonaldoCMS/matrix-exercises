/*
1) creare una funzione che accetta in ingresso un array numerico di qualsiasi lunghezza e 
un numero e ritorna il numero delle volte che tale numero è presente nell'array

es. arr [5,8,1,5]  x= 5    valore di ritorno=2

2) creare una funzione che accetta in ingresso un array numerico di 
qualsiasi lunghezza e ritorna il numero degli elementi positivi presenti nell'array

3) creare una funzione che accetta in ingresso un array numerico di
 qualsiasi lunghezza e ritorna il numero degli elementi negativi presenti nell'array

4) creare una funzione che accetta in ingresso un array numerico di 
qualsiasi lunghezza e ritorna il numero degli elementi pari pre


Poiché non ho voluto utilizzare ne una classe e neanche un modulo per rendere
ancora più sensato il codice, ho deciso di utilizzare _ davanti ai metodi per simulare
dei metodi privati che non dovrebbero essere utilizzare dal controller
 */

/*** define if value import is number or not
 */
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

function _arrayWithOnlyNumbers(array) {
  for (var i = 0; i < array.length; i++) {
    if (!isANumber(array[i])) {
      return false;
    }
  }
  return true;
}

function _controllExceptions(array, num = undefined) {
  if (num != undefined && !isANumber(num)) {
    throw "is not a number";
  }

  if (!Array.isArray(array)) {
    throw "is not an array";
  }

  if (!_arrayWithOnlyNumbers(array)) {
    throw "Array not contains only numbers";
  }
}

function _formulePositiveOrNegative(value, isPositive) {
  return isPositive ? value >= 0 : value < 0;
}

function _formuleIsEvenOrOdd(value, isEven) {
  return isEven ? value % 2 == 0 : value % 2 == 1;
}

function _cycleNumbers(array, callback) {
  for (var i = 0; i < array.length; i++) {
    callback(array[i]);
  }
}

function _searchAndOutputGeneric(array, boolean, type, num=undefined) {
  
  try {
    _controllExceptions(array);
    console.log(array);
  } catch (error) {
    console.error(error);
    throw error;
  }

  var counter = 0;
  _cycleNumbers(array, (value) => {
    if(_incrementCounter(value, type, boolean, num)) {
      counter++;
    }
  });
  return counter;
}

function _incrementCounter(value, type=undefined, boolean=undefined, num=undefined) {
  console.log("START");
  if(num != undefined) {
    if(value == num) return true;
  } else {
    switch (type) {
      case 0:
        return _formuleIsEvenOrOdd(value, boolean);
      case 1:
        return _formulePositiveOrNegative(value, boolean);
      default:
        return false;
    }
  }
}

 function _searchAndOutputEvensOrOddValue(array, isEven) {
 return _searchAndOutputGeneric(array, isEven, 0);
}
 
 function _searchAndOutputPositivesOrNegativesValue(array, isPos) {
  return _searchAndOutputGeneric(array, isPos, 1);
}


outEvensValue = (array) => _searchAndOutputEvensOrOddValue(array, true);
outOddesValue = (array) => _searchAndOutputEvensOrOddValue(array, false);
outPositivesValue = (array) =>_searchAndOutputPositivesOrNegativesValue(array, true, 1);
outNegativesValue = (array) => _searchAndOutputPositivesOrNegativesValue(array, false, 1);
searchAndOutputTimesValue = (array, num) => _searchAndOutputGeneric(array, num=num);

