from flask import Flask, jsonify, request

app = Flask(__name__)

# Sample data
items = []

# GET endpoint to retrieve all items
@app.route('/items', methods=['GET'])
def get_items():
    return jsonify({'items': items})

# POST endpoint to add a new item
@app.route('/items', methods=['POST'])
def add_item():
    data = request.get_json()
    new_item = {
        'id': len(items) + 1,
        'name': data['name']
    }
    items.append(new_item)
    return jsonify(new_item), 201

if __name__ == '__main__':
    app.run(debug=True)