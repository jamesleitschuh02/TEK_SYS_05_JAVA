let btn = document.querySelector("#cityBtn");
let cityVal = document.querySelector("#city");
let contentDiv = document.querySelector("#content");
let hourMap = new Map();

btn.addEventListener("click", (event) => {
  event.preventDefault();
  citySearch(cityVal.value);
});

function citySearch(searchCity) {
  if (contentDiv.childElementCount != 0) {
    removeContent(contentDiv);
  }

  const city = searchCity;
  const key = "bf0a61546d9083e91b1a07813951c139";
  const url =
    "https://api.openweathermap.org/data/2.5/weather?q=" +
    city +
    "&appid=" +
    key +
    "&units=imperial";

  $.ajax({
    url: url,
    method: "GET",
  }).then(function (response) {
    getHourly(response, key);
  });
}

function getHourly(obj, key) {
  const url = "https://api.openweathermap.org/data/2.5/onecall";
  const lat = "?lat=" + obj.coord.lat;
  const lon = "&lon=" + obj.coord.lon;
  const queryURL = url + lat + lon + "&units=imperial" + "&appid=" + key;

  $.ajax({
    url: queryURL,
    method: "GET",
  }).then(function (response) {

    let times = [];

    for (let i = 0; i < 24; i++){

        let info = {
            cityName: obj.name,
            hourlyTemp: response.hourly[i].temp,
            hourlyDewPoint: response.hourly[i].dew_point,
            hourlyHumidity: response.hourly[i].humidity,
            hourlyWindSpeed: response.hourly[i].wind_speed,
            hourlyUvi: response.hourly[i].uvi,
            hourlyPressure: response.hourly[i].pressure
        };
    
        times.push(info);
    }
    hourMap.set(obj.name,times);
    console.log(times);
    createColumns(times);
    cityVal.value = '';
  });
}

function createList(times) {

    let tableColumn = document.createElement('div');
    tableColumn.className = 'col-sm-6';

    let table = document.createElement("table");
    table.className = "table table-striped";
    let thead = document.createElement("thead");
    let tr = document.createElement("tr");

    let thHour = document.createElement("th");
    thHour.setAttribute("scope", "col");
    thHour.innerHTML = "Hour";

    let thTemp = document.createElement("th");
    thTemp.setAttribute("scope", "col");
    thTemp.innerHTML = "Temperature";

    let thDewPoint = document.createElement("th");
    thDewPoint.setAttribute("scope", "col");
    thDewPoint.innerHTML = "Dew Point";

    let thHumidity = document.createElement("th");
    thHumidity.setAttribute("scope", "col");
    thHumidity.innerHTML = "Humidity";

    let thWindSpeed = document.createElement("th");
    thWindSpeed.setAttribute("scope", "col");
    thWindSpeed.innerHTML = "Wind Speed";

    let thUvi = document.createElement("th");
    thUvi.setAttribute("scope", "col");
    thUvi.innerHTML = "UVI";

    let thPressure = document.createElement("th");
    thPressure.setAttribute("scope", "col");
    thPressure.innerHTML = "Pressure";

    tr.appendChild(thHour);
    tr.appendChild(thTemp);
    tr.appendChild(thDewPoint);
    tr.appendChild(thHumidity);
    tr.appendChild(thWindSpeed);
    tr.appendChild(thUvi);
    tr.appendChild(thPressure);
    thead.appendChild(tr);
    table.appendChild(thead);

    let tableBody = document.createElement('tbody');
    tableBody.className = 'tableBody';

  
    for (let i = 0; i < times.length; i++) {
        let tr = document.createElement('tr');
        
        let th = document.createElement('th');
        th.setAttribute("scope", "row");
        th.innerHTML = i;
        tr.appendChild(th);

        let tdTemp = document.createElement('td');
        tdTemp.innerHTML = times[i].hourlyTemp + "&#8457;";

        let tdDew = document.createElement('td');
        tdDew.innerHTML = times[i].hourlyDewPoint + "&#176;";

        let tdHumidity = document.createElement('td');
        tdHumidity.innerHTML = times[i].hourlyHumidity + "%";

        let tdWind = document.createElement('td');
        tdWind.innerHTML = times[i].hourlyWindSpeed + " mph";

        let tdUvi = document.createElement('td');
        tdUvi.innerHTML = times[i].hourlyUvi;

        let tdPressure = document.createElement('td');
        tdPressure.innerHTML = times[i].hourlyPressure + " in";

        tr.appendChild(tdTemp);
        tr.appendChild(tdDew);
        tr.appendChild(tdHumidity);
        tr.appendChild(tdWind);
        tr.appendChild(tdUvi);
        tr.appendChild(tdPressure);

        tableBody.appendChild(tr);
    }

    table.appendChild(tableBody);
    tableColumn.appendChild(table);

    return tableColumn;
}

function removeContent(parent) {
    while (parent.firstChild) {
      parent.removeChild(parent.firstChild);
    }
  }

  function createHistory() {

    let historyColumn = document.createElement('div');
    historyColumn.className = 'col-sm-3';

    let title = document.createElement('h2');
    title.innerHTML = 'Search History';
    historyColumn.appendChild(title);
  
    let table = document.createElement("table");
    table.className = "table table-striped";
    let thead = document.createElement("thead");
    let tr = document.createElement("tr");
  
    let thCity = document.createElement("th");
    thCity.setAttribute("scope", "col");
    thCity.innerHTML = "City";
  
    tr.appendChild(thCity);
    thead.appendChild(tr);
    table.appendChild(thead);
  
    let tableBody = document.createElement("tbody");
    tableBody.className = 'tableBody';
  
    hourMap.forEach((values, keys) => {
  
      let tr2 = document.createElement("tr");
      tr2.className = 'listItem';
  
      let tableItem1 = document.createElement("td");
      tableItem1.innerHTML = keys;
      tr2.appendChild(tableItem1);
  
      tr2.addEventListener("click", (event) => {
        event.preventDefault();
        removeContent(contentDiv);
        createColumns(hourMap.get(keys));
      });
      tableBody.appendChild(tr2);
    });
  
    table.appendChild(tableBody);
    historyColumn.appendChild(table);
  
    return historyColumn;
  }

  function createColumns(times) {
    let row1 = document.createElement('div');
    row1.className = 'row';

    let tableColumn = createList(times);
    row1.appendChild(tableColumn);
    
    let spacer = document.createElement('div');
    spacer.className = 'col-sm-3';
    row1.appendChild(spacer);

    let historyColumn = createHistory();
    row1.appendChild(historyColumn);

    
    contentDiv.appendChild(row1);
  }