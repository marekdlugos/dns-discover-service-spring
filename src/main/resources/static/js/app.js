// Dummy data

var users = [
    {
        "id": 1,
        "name": "Marek Dlugos",
        "eamil": "marek@rocketbuilt.tech"
    },
    {
        "id": 2,
        "name": "Jakub Lecbych",
        "eamil": "marek@rocketbuilt.tech"
    },
    {
        "id": 3,
        "name": "Jiri Vokrinek",
        "eamil": "marek@rocketbuilt.tech"
    }
];

var activeUsers = [
    {
        "id": 1,
        "name": "Marek Dlugos",
        "eamil": "marek@rocketbuilt.tech"
    },
    {
        "id": 2,
        "name": "Jakub Lecbych",
        "eamil": "marek@rocketbuilt.tech"
    }
];

var roles = [
    {
        "id": 1,
        "name": "Watcher",
        "description": "slkdjaskd"
    },
    {
        "id": 2,
        "name": "Editor",
        "description": "slkdjaskd"
    },
    {
        "id": 3,
        "name": "Manager",
        "description": "slkdjaskd"
    },
    {
        "id": 4,
        "name": "Admin",
        "description": "slkdjaskd"
    }
];

// Roles fill

var option = '';
for (var i=0;i<roles.length;i++){
    option += '<option value="'+ roles[i].id + '">' + roles[i].name + '</option>';
}

$( document ).ready(function() {
    console.log(option);
    $('select#role1').append(option);
});