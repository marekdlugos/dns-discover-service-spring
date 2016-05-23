# API Documentation

## Project

### Create a new project

1. Request on new project

Method **POST** on `/projects/`

```
{
    "name" : "Basecamp",
    "description" : "Landing page"
}
```

2. Request to assign users and roles

Method **POST** on `/save`

```
[
    {
        "projectId" : 2,
        "accountId" : 1,
        "rolesIds" : [
            1
        ]
    },
    {
        "projectId" : 2,
        "accountId" : 2,
        "rolesIds" : [
            1
        ]
    }
]
```

### Read Project(s)

Method **GET** on `/projects/` -> return list of all Projects

Method **GET** on `projects/{projectId}` -> return detail of one Project

### Update Project(s)

1. Request is method **PUT** on `projects/{projectId}`
2. Request is method **POST** on `/save`

```
[
    {
        "projectId" : 2,
        "accountId" : 1,
        "rolesIds" : [
            1
        ]
    }
]
```

### Delete Project

Method **DELETE** on `/projects/{projectId}` -> {projectId} -> ID of project you want to delete

## DNS Record

### Create a new DNS Record

Method **POST** on `/dnsrecords/{projectId}` -> {projectId} -> ID of project you want DNS Record assign to

```
{
    "zone": "adastra.cz",
    "host": "adastra.cz.",
    "ttl": 86400,
    "type": "MX",
    "mx_priority": 21000,
    "data": "adastra.com",
    "resp_person": "adastra",
    "serial": 21094210,
    "refresh": 32000,
    "retry": 12000,
    "expire": 29001,
    "minimum": 21382
}
```

### Read DNS Record(s)

Method **GET** on `dnsrecords/` -> return list of all DNS Records

Method **GET** on `dnsrecords/{dnsRecordId}` -> return detail of one DNS Record

### Edit a new DNS Record

Method **PUT** on `/dnsrecords/{dnsRecordId}/project/{projectId}` -> {projectId} -> ID of project you want DNS Record assign to

```
{
    "zone": "adastra.cz",
    "host": "adastra.cz.",
    "ttl": 86400,
    "type": "MX",
    "mx_priority": 21000,
    "data": "adastra.com",
    "resp_person": "adastra",
    "serial": 21094210,
    "refresh": 32000,
    "retry": 12000,
    "expire": 29001,
    "minimum": 21382
}
```

### Delete DNS Record

Method **DELETE** on `dnsrecords/{dnsRecordId}` -> ID of DNS Record you want to delete

## Account

### Create a new Account

Method **POST** on `/users/`

```
{
    "name" : "Trol Malor",
    "email" : "trol@malor.sk",
    "password" : "password"
}
```

### Read Accounts

Method **GET** on `users/` -> return a list of all Users

Method **GET** on `users/{userId}` -> return detail of one User

### Update an Account

Method **PUT** on `/users/{userId}` -> ID of User you want to update

```
{
    "name" : "Trol Malor",
    "email" : "trol@malor.sk",
    "password" : "password"
}
```

### Delete an Account

Method **DELETE** on `/users/{userId}` -> ID of user you want to delete