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
    return "Hi " f'{name}'
@app.route('/repeat/<times>/<name>')
def repeat(times, name):
    return f'{name} ' * int(times)
if __name__=="__main__":    
    app.run(debug=True)    
    
    