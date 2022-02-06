
from flask import Flask ,render_template,request
app=Flask(__name__)

@app.route("/")
def form():
    return render_template("dojo.html")

@app.route("/result", methods=['post'])
def result():
    name=request.form['username']
    location=request.form["location"]
    lang=request.form['fav']
    comment=request.form['comment']
    return render_template('show.html',name_from_python=name,location_from_python=location,lang_from_python=lang,comment_from_python=comment)



if __name__=="__main__":
    app.run(debug=True)