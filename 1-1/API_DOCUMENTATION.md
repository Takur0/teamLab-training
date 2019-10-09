## item [/api/items]

## Items collections /api/items{/id}
### Find all items [GET]
+ Response 200 (application/json)
    + Body
    ```json
    {
        "items": [
            {
            "id": 1,
            "title": "milk",
            "description": "milk",
            "price": 130,
            "image_url": "https://..."
            },             
            {
            "id": 2,
            "title": "chocolate",
            "description": "chocolate",
            "price": 130,
            "image_url": "https://..."
            }, 
            ...
        ]
    }
    ```
+ Response 404 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "No items."
        }
    }
    ```
### Find item by ID [GET]
+ Parameters
    + id: `1` (int, require)
+ Response 200 (application/json)
    + Body
    ```json
    {
        "item": {
            "id": 1,
            "title": "milk",
            "description": "milk",
            "price": 130,
            "image_url": "https://..."
        }
    }
    ```
+ Response 404 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "This ID is not found."
        }
    }
    ```

### Update an item [PUT]
+ Parameters
    + id: `1` (int, require)
+ Response 204 (application/json)
    + Body
    ```json
    {
        "message": "Successfully updated!",
        "item": {
            "id": 1,
            "title": "milk",
            "description": "milk",
            "price": 130,
            "image_url": "https://..."
        }
    }
    ```
+ Response 400 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "Invalid parameter."
        }
    }
    ```
+ Response 404 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "This ID is not found"
        }
    }
    ```

### Delete an item [DELETE]
+ Parameters
    + id: `1` (int, require)
+ Response 204 (application/json)
    + Body
    ```json
    {
        "status": {
            "message": "Successfully deleted."
        }
    }
    ```
+ Response 404 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "This ID is not found"
        }
    }
    ```

### Add new item [POST]
+ Response 201 (application/json)
    + Body
    ```json
    {
        "message" :"Successfully added!",
        "item": {
            "id": 1,
            "title": "milk",
            "description": "milk",
            "price": 130,
            "image_url": "https://..."
        }
    }
    ```
+ Response 400 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "Invalid parameter."
        }
    }
    ```

+ Response 409 (application/json)
    + Body
    ```json
    {
        "error": {
            "message": "Conflict."
        }
    }
    ```
