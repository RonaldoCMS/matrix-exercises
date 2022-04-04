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

function _controllAndRunMethod(array, callback) {
  _controllExceptions(array);
  callback();
}

function _formulePositiveOrNegative(value, isPositive) {
  return isPositive ? value >= 0 : value < 0;
}

function _formuleIsEvenOrOdd(value, isEven) {
  return isEven ? value % 2 == 0 : value % 2 == 1;
}

function formulePositiveValue(value) {
  return _formulePositiveOrNegative(value, true);
}

function formuleNegativeValue(value) {
  return _formulePositiveOrNegative(value, false);
}

function formuleEvenValue(value) {
  return _formuleIsEvenOrOdd(value, true);
}

function formuleOddValue(value) {
  return _formuleIsEvenOrOdd(value, false);
}

function _cycleNumbers(array, callback) {
  for (var i = 0; i < array.length; i++) {
    callback(array[i]);
  }
}

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


outEvensValue = (array) => {
  let evens = 0;
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      if(formuleEvenValue(value)) {
        evens++;
      }
    });
  });
  return evens;
}

outOddesValue = (array) => { 
  let oddes = 0;
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      if(formuleOddValue(value)) {
        oddes++;
      }
    });
  });
  return oddes;
}

outPositivesValue = (array) =>{ 
  let positives = 0;
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      if(formulePositiveValue(value)) {
        positives++;
      }
    });
  });
  return positives;
}

outNegativesValue = (array) => {
  let negatives = 0;
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      if(formuleNegativeValue(value)) {
        negatives++;
      }
    });
  });
  return negatives;
}

outMaxValue = (array) => {
  let max = array[0];
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      console.log("ENTER " + max);
      max = _max(value, max);
    });
  });
  return max;
};

outMinValue = (array) => {
  let min = array[0]; 
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      min = _min(value, min);
    });
  });
  return min;
}

searchAndOutputTimesValue = (array, num) => {
  let total = 0; 
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value) => {
      if(value == num) {
        total++;
      }
    });
  });
  return total;
};

outMediaValue = (array) => {
 let total = outSumValue(array);
 return total / array.length;
}

outSumValue = (array) => {
  let total = 0;
  _controllAndRunMethod(array, () => {
    _cycleNumbers(array, (value)  => {
      total += parseInt(value);
    });
  });
  return total;
}