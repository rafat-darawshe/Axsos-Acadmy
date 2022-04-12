import React, { useState } from 'react'
import './stayle.css';


const Form = (props) => {
    const [color, setColor]=useState("");
    const createBox = (e)=>{
        e.preventDefault();
        props.myFun(color);
        setColor("");
    }
  return (
    <div>
        <form onSubmit={createBox} >
            <div >
                <label>color:</label>
                <input className="rafat" type="text" onChange={(e) => setColor(e.target.value)} value= {color} />
                <input className="rafat1" type="submit" value="add" />
            </div>
        </form>
    </div>
  )
}

export default Form