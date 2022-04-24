import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import axios from 'axios';
import { Link } from "react-router-dom";
import { Table, Button } from 'react-bootstrap';

    
const AuthorList = (props) => {
    const { removeFromDom } = props;
    
    const deleteAuthor = (authorId) => {
        axios.delete('http://localhost:8000/api/author/' + authorId)
            .then(res => {
                removeFromDom(authorId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div>
            <h1>All author:</h1>
            <Link  to={"/author/new"}>New Author</Link>
            <Table striped bordered hover variant="dark">
                <thead>
                    <tr>
                        <th>Author</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {props.author.map( (author, i) =>
                        <tr key={i}>
                            <td>{author.name}</td>
                            <td>
                            <Button onClick={(e)=>{deleteAuthor(author._id)}}>
                                Delete
                            </Button>
                            <Button href={"/author/" + author._id + "/edit"}>
                                Edit
                            </Button>
                            </td>
                        </tr>
                            )}

                </tbody>
            </Table>
        </div>
    )
}
    
export default AuthorList;
