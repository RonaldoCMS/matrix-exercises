document.getElementById("list_numbers").value = "0,1,2,3,4,5";



function _getValues(values) {
   try {
    return `
    positivi : <b> ${outPositivesValue(values)} </b>    <br>
    negativi : <b> ${outNegativesValue(values)} </b>    <br>
    pari :     <b> ${outEvensValue(values)}     </b>    <br>
    dispari :  <b> ${outOddesValue(values)}     </b>    <br>
    Massimo :  <b> ${outMaxValue(values)}       </b>    <br>
    Minimo :   <b> ${outMinValue(values)}       </b>    <br>
    Media :    <b> ${outMediaValue(values)}     </b>    <br>
    Sum :      <b> ${outSumValue(values)}       </b>    <br>
    `
   } catch(error) {
       throw error;
   }
}

function getTimesValue(values) {
    const isActiveSearchTimes = isANumber(document.getElementById("input-times").value);
    if(isActiveSearchTimes) {
        const times =  parseInt(document.getElementById("input-times").value);
        return ` <b> doppioni ${searchAndOutputTimesValue(values, times)} </b>`;
    }
    return '';
}

function _getResultHTML(paragraphy) {
    try {
        document.getElementById('text-result').innerHTML = paragraphy
    } catch(error) {
        document.getElementById("result").innerHTML += "<p id='text-result' >" + paragraphy + "</p>";
    }

}

function getResults()  {
    var valuesFromDOM = document.getElementById("list_numbers").value;
    var values = valuesFromDOM.split(',');
    console.log("input times" + document.getElementById("input-times").value + "value");

    console.log(values);
    if(values.length === 0 || values[0] == "" || values[0] == " " || values === null) {
        document.getElementById("result").innerHTML += "<p id='text-result> Inserisci elementi nella textArea </p>";
        return;
    }
    var paragraphy;
    try {
        paragraphy = _getValues(values)
    } catch(error) {
        paragraphy = error;
        _getResultHTML(paragraphy);
        return;
    }
    paragraphy += getTimesValue(values);
    _getResultHTML(paragraphy);
}

function clearResults() {
    console.log("Hello");
    document.getElementById('result').innerHTML = ""
    document.getElementById("list_numbers").value = "";
} 