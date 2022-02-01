from flask import Flask  
app = Flask(__name__)    
@app.route('/')          
def hello_world():
    return 'Hello World!'  
@app.route('/dojo')
def dojo():
  return "dojo"
@app.route('/Hi/<name>')
def hello(name):
    print(name)
    return "Hi, + name
@app.route('/repeat/<times>/<name>')
def name(times, name):
    print(name)
    print(times)
    return f'{name}' * int(times)
if __name__=="__main__":    
    app.run(debug=True)    
    
    