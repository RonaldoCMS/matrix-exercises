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

outEvensValue = (array) => {
  let evens = 0;
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      if(formuleEvenValue(value)) {
        evens++;
      }
    });
  });
  return evens;
}

outOddesValue = (array) => { 
  let oddes = 0;
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      if(formuleOddValue(value)) {
        oddes++;
      }
    });
  });
  return oddes;
}

outPositivesValue = (array) =>{ 
  let positives = 0;
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      if(formulePositiveValue(value)) {
        positives++;
      }
    });
  });
  return positives;
}

outNegativesValue = (array) => {
  let negatives = 0;
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      if(formuleNegativeValue(value)) {
        negatives++;
      }
    });
  });
  return negatives;
}

outMaxValue = (array) => {
  let max = array[0];
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      console.log("ENTER " + max);
      max = _max(value, max);
    });
  });
  return max;
};

outMinValue = (array) => {
  let min = array[0]; 
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      min = _min(value, min);
    });
  });
  return min;
}

searchAndOutputTimesValue = (array, num) => {
  let total = 0; 
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value) => {
      if(value == num) {
        total++;
      }
    });
  });
  return total;
};

outMediaValue = array => outSumValue(array) / array.length;


outSumValue = (array) => {
  let total = 0;
  controllAndRunMethod(array, () => {
    cycleNumbers(array, (value)  => {
      total += parseInt(value);
    });
  });
  return total;
}

outReversedArray = (array) => {
  let reversed = [];
  controllAndRunMethod(array, () => {
    for(let i = array.length; i >= 0; i--) {
      reversed.push(array[i]);
    }
    //Strada più facile
    //return Array.from(array).reverse();
  });
  return reversed;
}