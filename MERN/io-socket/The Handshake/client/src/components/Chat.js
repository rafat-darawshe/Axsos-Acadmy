import io from 'socket.io-client';
import React, { useState, useEffect } from 'react';


const Chat = () => {
    const [socket] = useState(() => io(':8000'));
    const [text, setText]=useState("");
    const [chat, setChat]=useState([]);
    useEffect(() => {
        console.log('Is this running?');
        socket.on('connection', data => console.log(data));
        socket.on('message', data => {console.log(data);setChat([...chat,data])});
    });
    const onSubmitHandler =e=> {
        e.preventDefault()
        socket.emit("message",text)
        setChat([...chat,text])
    }
  return (
        <div>
            <div>
                {chat.map((msg,i) => <p key={i}>{msg}</p>)}
            </div>
        
    <div>
        <form onSubmit={onSubmitHandler}>
            <input type="text" onChange={e => setText(e.target.value)}/>
            <input type="submit" value="send"/>
        </form>
    </div>
    </div>
  )
}

export default Chat