let btn = document.querySelector("#cityBtn");
let cityVal = document.querySelector("#city");
let contentDiv = document.querySelector("#content");
let cityMap = new Map();

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
    getDailys(response, key);
  });
}

function getDailys(obj, key) {
  const url = "https://api.openweathermap.org/data/2.5/onecall";
  const lat = "?lat=" + obj.coord.lat;
  const lon = "&lon=" + obj.coord.lon;
  const queryURL = url + lat + lon + "&units=imperial" + "&appid=" + key;

  $.ajax({
    url: queryURL,
    method: "GET",
  }).then(function (response) {
    console.log(response);

    let info = {
      cityName: obj.name,
      cityTemp: obj.main.temp,
      feelsLike: obj.main.feels_like,
      icon:
        "http://openweathermap.org/img/wn/" +
        response.current.weather[0].icon +
        "@2x.png",
      min: obj.main.temp_min,
      max: obj.main.temp_max,
      morn: response.daily[0].feels_like.morn,
      day: response.daily[0].feels_like.day,
      night: response.daily[0].feels_like.night,
      dewPoint: response.current.dew_point,
      wind: obj.wind.speed,
      humidity: response.current.humidity,
      uv: response.current.uvi,
    };

    listData(info);
  });
}

function listData(obj) {
  cityMap.set(obj.cityName, obj.cityTemp);

  let cityHeader = document.createElement("h2");
  cityHeader.id = "cityName";
  cityHeader.innerHTML = obj.cityName;
  contentDiv.appendChild(cityHeader);

  let divContainer = document.createElement("div");
  divContainer.className = "container";

  let divRow = document.createElement("div");
  divRow.className = "row align-items-center";

  let iconDiv = document.createElement("div");
  iconDiv.id = "iconDiv";
  iconDiv.className = "col-sm-4";
  let iconImg = document.createElement("img");
  iconImg.src = obj.icon;
  iconImg.id = "iconImg";
  iconDiv.appendChild(iconImg);
  divRow.appendChild(iconDiv);

  let firstList = document.createElement("dl");
  firstList.className = "col-sm-4";
  firstList.id = 'firstList';

  let itemOne = document.createElement("dt");
  itemOne.innerHTML =obj.cityTemp + "&#8457;";
  itemOne.id = 'currentTemp';
  firstList.appendChild(itemOne);
  let itemTwo = document.createElement("dt");
  itemTwo.innerHTML = "<i>Feels Like:</i> " + obj.feelsLike + "&#8457;";
  firstList.appendChild(itemTwo);
  let itemThree = document.createElement("dt");
  itemThree.innerHTML = "High: " + obj.max + "&#8457;<br>Low: " + obj.min + "&#8457;";
  firstList.appendChild(itemThree);
  divRow.appendChild(firstList);

  let secondList = document.createElement("dl");
  secondList.className = "col-sm-4";
  secondList.id = 'secondList';

  let itemFour = document.createElement("dt");
  itemFour.innerHTML = "Wind Speed: " + obj.wind + " mph";
  secondList.appendChild(itemFour);
  let itemFive = document.createElement("dt");
  itemFive.innerHTML = "Dew Point: " + obj.dewPoint + "&#176;";
  secondList.appendChild(itemFive);
  let itemSix = document.createElement("dt");
  itemSix.innerHTML = "Humidity: " + obj.humidity + "%";
  secondList.appendChild(itemSix);
  divRow.appendChild(secondList);

  divContainer.appendChild(divRow);

  let divRow2 = document.createElement("div");
  divRow2.className = "row align-items-center";

  let morning = createCard(obj.morn, "Morning");
  divRow2.appendChild(morning);

  let day = createCard(obj.day, "Day");
  divRow2.appendChild(day);

  let night = createCard(obj.night, "Night");
  divRow2.appendChild(night);

  divContainer.appendChild(divRow2);

  contentDiv.appendChild(divContainer);

  let historyTitle = document.createElement("h2");
  historyTitle.id = "cityHistoryTitle";
  historyTitle.innerHTML = "Search History";
  contentDiv.appendChild(historyTitle);

  let row3 = document.createElement('div');
  row3.className = 'row';

  let space3 = document.createElement('div');
  space3.className = 'col-sm-3';
  row3.appendChild(space3);

  let historyColumn = document.createElement('div');
  historyColumn.className = 'col-sm-6';
  let historyList = createList();
  historyColumn.appendChild(historyList);
  row3.appendChild(historyColumn);
  contentDiv.appendChild(row3);

  cityVal.value = "";
}

function createCard(text, title) {
  let column = document.createElement("div");
  column.className = "col-sm-4";

  let card = document.createElement("div");
  card.className = "card";

  let cardTitle = document.createElement("h4");
  cardTitle.innerHTML = title;
  card.appendChild(cardTitle);

  let cardBody = document.createElement("div");
  cardBody.className = "card-body";
  cardBody.innerHTML = text + "&#8457;";

  card.appendChild(cardBody);
  column.appendChild(card);

  return column;
}

function createList() {
  let table = document.createElement("table");
  table.className = "table table-striped";
  let thead = document.createElement("thead");
  let tr = document.createElement("tr");

  let thNumber = document.createElement("th");
  thNumber.setAttribute("scope", "col");
  thNumber.innerHTML = "#";

  let thCity = document.createElement("th");
  thCity.setAttribute("scope", "col");
  thCity.innerHTML = "City";

  let thTemp = document.createElement("th");
  thTemp.setAttribute("scope", "col");
  thTemp.innerHTML = "Temperature";

  tr.appendChild(thNumber);
  tr.appendChild(thCity);
  tr.appendChild(thTemp);
  thead.appendChild(tr);
  table.appendChild(thead);

  let tableBody = document.createElement("tbody");
  tableBody.id = 'tableBody';

  let i = 0;
  cityMap.forEach((values, keys) => {
    console.log(values, keys);

    let tr2 = document.createElement("tr");
    let tableRow = document.createElement("th");
    tableRow.setAttribute("scope", "row");
    tableRow.innerHTML = i + 1;
    tr2.appendChild(tableRow);

    let tableItem1 = document.createElement("td");
    tableItem1.innerHTML = keys;
    tr2.appendChild(tableItem1);

    let tableItem2 = document.createElement("td");
    tableItem2.innerHTML = values;
    tr2.appendChild(tableItem2);

    tr2.addEventListener("click", (event) => {
      event.preventDefault();
      citySearch(keys);
    });
    tableBody.appendChild(tr2);
    i++;
  });

  table.appendChild(tableBody);
  return table;

  // contentDiv.appendChild(table);
}

function removeContent(parent) {
  while (parent.firstChild) {
    parent.removeChild(parent.firstChild);
  }
}
