let btn = document.querySelector("#cityBtn");
let cityVal = document.querySelector("#city");
let contentDiv = document.querySelector("#content");
let dailyMap = new Map();

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
    getDaily(response, key);
  });
}

function getDaily(obj, key) {
  const url = "https://api.openweathermap.org/data/2.5/onecall";
  const lat = "?lat=" + obj.coord.lat;
  const lon = "&lon=" + obj.coord.lon;
  const queryURL = url + lat + lon + "&units=imperial" + "&appid=" + key;

  $.ajax({
    url: queryURL,
    method: "GET",
  }).then(function (response) {
    let days = [];

    for (let i = 0; i < 6; i++) {
      let info = {
        temp: response.daily[i].temp.day,
        icon:
          "http://openweathermap.org/img/wn/" +
          response.daily[i].weather[0].icon +
          "@2x.png",
        humidity: response.daily[i].humidity,
      };

      days.push(info);
    }
    dailyMap.set(obj.name, days);
    createColumns(days);

    let row = document.createElement('div');
    row.className = 'row';

    let spacer = document.createElement('div');
    spacer.className = 'col-sm-3';
    row.appendChild(spacer);

    let historyColumn = document.createElement('div');
    historyColumn.className = 'col-sm-6';

    let history = createHistory();
    historyColumn.appendChild(history);
    row.appendChild(historyColumn);
    contentDiv.appendChild(row);

    cityVal.value = "";
  });
}

function removeContent(parent) {
  while (parent.firstChild) {
    parent.removeChild(parent.firstChild);
  }
}

function createCard(day) {
  // let today = new Date();
  // let dd = String(today.getDate()).padStart(2, '0');
  // let mm = String(today.getMonth() + 1).padStart(2, '0');
  // today = mm + '/' + dd;
  let card = document.createElement("div");
  card.className = "card";

  let cardBody = document.createElement("div");
  cardBody.className = "card-body";

  let dayTemp = document.createElement("h5");
  dayTemp.innerHTML = day.temp + "&#8457;";
  cardBody.appendChild(dayTemp);

  let dayIcon = document.createElement('img');
  dayIcon.src = day.icon;
  cardBody.appendChild(dayIcon);

  let dayHum = document.createElement('div');
  dayHum.innerHTML = 'Humidity: ' + day.humidity + '%';
  cardBody.appendChild(dayHum);

  card.appendChild(cardBody);

  return card;
}

function createColumns(days) {
  console.log(days);
  let row = document.createElement("div");
  row.className = "row";

  for (let i = 0; i < days.length; i++) {
    let column = document.createElement("div");
    column.className = "col-sm-2";
    let card = createCard(days[i]);
    column.appendChild(card);
    row.appendChild(column);
  }

  contentDiv.appendChild(row);
}

function createHistory() {

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

  dailyMap.forEach((values, keys) => {
    let tr2 = document.createElement("tr");
    tr2.id = 'listItem';

    let tableItem1 = document.createElement("td");
    tableItem1.innerHTML = keys;
    tr2.appendChild(tableItem1);

    tr2.addEventListener("click", (event) => {
      event.preventDefault();
      removeContent(contentDiv);
      console.log(dailyMap.get(keys));
      createColumns(dailyMap.get(keys));
      let row = document.createElement('div');
    row.className = 'row';

    let spacer = document.createElement('div');
    spacer.className = 'col-sm-3';
    row.appendChild(spacer);

    let historyColumn = document.createElement('div');
    historyColumn.className = 'col-sm-6';

    let history = createHistory();
    historyColumn.appendChild(history);
    row.appendChild(historyColumn);
    contentDiv.appendChild(row);

    });
    tableBody.appendChild(tr2);
  });

  table.appendChild(tableBody);

  return table;
}
