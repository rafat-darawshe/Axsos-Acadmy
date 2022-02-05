from os import times
from flask import Flask, render_template  
app = Flask(__name__)                     
    
@app.route('/a')                           
def hello():
    return render_template('Checkerboard.html',)  

if __name__=="__main__":
    app.run(debug=True)    