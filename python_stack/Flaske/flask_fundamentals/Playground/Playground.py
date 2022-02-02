from os import times
from flask import Flask, render_template  
app = Flask(__name__)                     
    
@app.route('/play')                           
def hello():

    return render_template('play.html', num_s=3)  
@app.route('/play/<num>')                           
def index(num):

    return render_template('play.html', num_s=int(num))  

@app.route('/play/<num>/<color>')                           
def color_play(num,color):

    return render_template('play.html', num_s=int(num), color_p=color)  
        
    
if __name__=="__main__":
    app.run(debug=True)    