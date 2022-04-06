function matrixSum(array) {
    let sum = 0;
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (j) => {
                    sum+=j;
                });
            }
        });
    });
    console.log("sum: \t" + sum);
    return sum;
}

function matrixMedia(array) {
    return sumVectors(array) / (array[0].length + array[1].length);
}

  function matrixPositives(array) {
    let positive = 0;
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (value) => {
                    if(formulePositiveValue(value)) {
                        positive++;
                    }
                });
            }
        });
    });
    return positive;
}

function matrixNegatives(array) {
    let negatives = 0;
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (value) => {
                    if(formulePositiveValue(value)) {
                        negatives++;
                    }
                });
            }
        });
    });
    return negatives;
}

  function matrixEvens(array) {
    let evens = 0;
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (value) => {
                    if(formuleEvenValue(value)) {
                        evens++;
                    }
                });
            }
        });
    });
    return evens;
}

function matrixOddes(array) {
    let oddes = 0;
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (value) => {
                    if(formuleOddValue(value)) {
                        oddes++;
                    }
                });
            }
        });
    });
    return oddes;
}

function matrixMaxValue(array) {
    let max = array[0][0];
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (value) => {
                   max = _max(value, max)
                });
            }
        });
    });
    return max;
}

function matrixMinValue(array) {
    let min = array[0][0];
    controllAndRunMethod(array[0], () => {
        controllAndRunMethod(array[1], () => {
            for(let i = 0; i < 2; i++) {
                cycleNumbers(array[i], (value) => {
                    min = _min(value, min)
                });
            }
        });
    });
    return min;
}

console.log(console.log([2],[2]));