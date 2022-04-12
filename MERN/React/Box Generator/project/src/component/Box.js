import React from 'react'


const Box = (props) => {
    return (
        <div>
        <div style={{display: "flex", flexWrap: 'wrap'}}>
            {props.myBoxes.map((color, i) => {
                const myStyle={ backgroundColor: color,
                                width:250,
                                height:250,
                                marginRight:15,
                                marginTop:15 };
                return(
                    <div key={i} style={myStyle}></div>
                )
            })}
        </div>


        </div>
    )
}

export default Box