# Spring Boot with PostgreSQL DB

Demo project.

### Test

**3. Insert Data**
```
curl --location --request POST 'http://localhost:8080/api/v1/person' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name": "Rebecca Ferguson"
}'
```

**2. Insert Data in Bulk**
```
curl --location --request POST 'http://localhost:8080/api/v1/person/bulk' \
--header 'Content-Type: application/json' \
--data-raw '[
	{
		"name": "Arnold Schwarzeneger"
	},
	{
		"name": "Bill Hader"	
	},
	{
		"name": "Chris Evans"
	},
	{
		"name": "Daniel Radcliff"
	}
]'
```

**2. Get All Person**
```
curl --location --request GET 'http://localhost:8080/api/v1/person' \
--data-raw ''
```

**3. Get Person By ID**
```
curl --location --request GET 'http://localhost:8080/api/v1/person/61981dd4-92e0-4d55-9d66-55e3c592db3b'
```

**4. Update Person By ID**
```
curl --location --request PUT 'http://localhost:8080/api/v1/person/61981dd4-92e0-4d55-9d66-55e3c592db3b' \
--header 'Content-Type: application/json' \
--data-raw '{
	"id": "61981dd4-92e0-4d55-9d66-55e3c592db3b",
	"name": "Arnold Schwarzenegger"
}'
```

**5. Delete Person By ID**
```
curl --location --request DELETE 'http://localhost:8080/api/v1/person/61981dd4-92e0-4d55-9d66-55e3c592db3b'
```
