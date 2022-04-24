import React, { useEffect, useState } from 'react';
import axios from 'axios';
import AuthortList from '../components/AuthortList';
const Main = (props) => {
    const [author, setAuthort] = useState([]);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(()=>{
        axios.get('http://localhost:8000/api/author')
            .then(res=>{
                setAuthort(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);

    
    const removeFromDom = authorId => {
        setAuthort(author.filter(author => author._id != authorId));
    }

    return (
        <div>
           <hr/>
           {loaded && <AuthortList author={author} removeFromDom={removeFromDom}/>}
        </div>
    )
}

export default Main
