# API Documentation

## Project

### Create a new project

1.

## DNS Record

### Create a new DNS Record

Method **POST** on `dnsrecords/{projectId}`

{projectId} -> ID of project you want DNS Record assign to

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
