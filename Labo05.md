---
title: Labo05
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.30"

---

# Labo05

Base URLs:

# Authentication

# Default

## GET Filter by pages

GET /api/books

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|minPages|query|string| yes |none|
|maxPages|query|string| yes |none|

> Response Examples

> 200 Response

```json
[
  {
    "id": "dc8af65e-941f-4e32-baf9-1e3f4829d8f4",
    "title": "50 sombras de grey",
    "author": "Nayib",
    "isbn": "123-4567890123",
    "publicationYear": 2023,
    "language": "English",
    "pages": 300,
    "genre": "Fiction"
  },
  {
    "id": "efbb1f93-8258-4ad0-87e5-1e57702c6cc2",
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "isbn": "978-0-7432-7356-5",
    "publicationYear": 1925,
    "language": "English",
    "pages": 180,
    "genre": "Classic Literature"
  },
  {
    "id": "4d2d6ed8-45c2-4a0e-bf9e-607e6c7004e7",
    "title": "The Catcher in the Rye",
    "author": "J.D. Salinger",
    "isbn": "978-0-316-76948-0",
    "publicationYear": 1951,
    "language": "English",
    "pages": 277,
    "genre": "Coming of Age"
  },
  {
    "id": "e420c796-8971-44aa-b514-2dc57472feb7",
    "title": "Fahrenheit 451",
    "author": "Ray Bradbury",
    "isbn": "978-84-663-0007-3",
    "publicationYear": 1953,
    "language": "Español",
    "pages": 249,
    "genre": "Science Fiction"
  },
  {
    "id": "a90f3082-25d4-42f4-a449-7743a6293420",
    "title": "El Alquimista",
    "author": "Paulo Coelho",
    "isbn": "978-84-08-04711-4",
    "publicationYear": 1988,
    "language": "Español",
    "pages": 163,
    "genre": "Filosofía"
  },
  {
    "id": "48fda6c8-f6e5-4108-982c-d8e1f293b10d",
    "title": "Crónica de una muerte anunciada",
    "author": "Gabriel García Márquez",
    "isbn": "978-84-339-2951-2",
    "publicationYear": 1981,
    "language": "Español",
    "pages": 122,
    "genre": "Realismo Mágico"
  }
]
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

HTTP Status Code **200**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» id|string|true|none||none|
|» title|string|true|none||none|
|» author|string|true|none||none|
|» isbn|string|true|none||none|
|» publicationYear|integer|true|none||none|
|» language|string|true|none||none|
|» pages|integer|true|none||none|
|» genre|string|true|none||none|

## POST CreateBook

POST /api/books

> Body Parameters

```json
{
  "title": "Libro de Prueba 1",
  "author": "Autor Test",
  "isbn": "978-3-16-148410-0",
  "publicationYear": 2020,
  "language": "Español",
  "pages": 250,
  "genre": "Ficción"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» title|body|string| yes |none|
|» author|body|string| yes |none|
|» isbn|body|string| yes |none|
|» publicationYear|body|integer| yes |none|
|» language|body|string| yes |none|
|» pages|body|integer| yes |none|
|» genre|body|string| yes |none|

> Response Examples

> 201 Response

```json
"Libro creado exitosamente"
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|none|Inline|

### Responses Data Schema

## DELETE Borrar libro

DELETE /api/books/{isbn}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|isbn|path|string| yes |none|

> Response Examples

> 200 Response

```json
"Libro eliminado exitosamente"
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## PUT actualizar titulo

PUT /api/books/{isbn}/title

> Body Parameters

```json
{
  "title": "50 Sombras de grey"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|isbn|path|string| yes |none|
|body|body|object| no |none|
|» title|body|string| yes |none|

> Response Examples

> 200 Response

```json
"Título actualizado exitosamente"
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## PUT Actualizar idioma

PUT /api/books/{isbn}/language

> Body Parameters

```json
{
  "language": "Turco"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|isbn|path|string| yes |none|
|body|body|object| no |none|
|» language|body|string| yes |none|

> Response Examples

> 200 Response

```json
"Idioma actualizado exitosamente"
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

# Data Schema

