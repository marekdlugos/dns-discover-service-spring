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

Method **POST** on `/save/`

```
[
    {
        "projectId" : 2,
        "accountId" : 1,
        "rolesIds" : [
            1,
            2
        ]
    }
]
```

## DNS Record

### Create a new DNS Record

Method **POST** on `/dnsrecords/{projectId}` -> {projectId} -> ID of project you want DNS Record assign to

#### Body example

JSON application/JSON

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

### Edit a new DNS Record

Method **PUT** on `/dnsrecords/{dnsRecordId}/project/{projectId}` -> {projectId} -> ID of project you want DNS Record assign to

#### Body example

JSON application/JSON

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