function sprinklerStatus(sprinklerTag) {
  var request = new XMLHttpRequest();
  request.open("GET", "sprinkler/switch/0", true);

  request.onload = function(evt) {
    var response = JSON.parse(request.responseText);
    document.getElementById(sprinklerTag).innerHTML = response.enabled ? "Sprinkler Enabled" : "Sprinkler Disabled";
  };

  request.send();
}

function doorStatus(doorTag) {
  var request = new XMLHttpRequest();
  request.open("GET", "door/lastevent", true);

  request.onload = function(evt) {
    var response = JSON.parse(request.responseText);
    document.getElementById(doorTag).innerHTML = "Motion Detected: " + response.datetime;
  };

  request.send();
}

function systemStatus(systemPanel, systemTag) {
  var request = new XMLHttpRequest();
  request.open("GET", "monit/", true);

  request.onload = function(evt) {
    var firstIdx = request.responseText.indexOf("red-text");
    var errors = request.responseText.indexOf("red-text", firstIdx + 1) > 0;
    firstIdx = request.responseText.indexOf("gray-text");
    var warnings = request.responseText.indexOf("gray-text", firstIdx + 1) > 0;

    if(errors) {
      document.getElementById(systemTag).innerHTML = "Subsystem Errors";
      document.getElementById(systemPanel).className = "panel panel-danger";
    } else if(warnings) {
      document.getElementById(systemTag).innerHTML = "Subsystem Warnings";
      document.getElementById(systemPanel).className = "panel panel-warning";
    } else {
      document.getElementById(systemTag).innerHTML = "Online";
      document.getElementById(systemPanel).className = "panel panel-success";
    }
  };

  request.send();
}

function navigateTo(panel, path) {
  panel.className = "panel panel-default";
  window.location.assign(path);
}
