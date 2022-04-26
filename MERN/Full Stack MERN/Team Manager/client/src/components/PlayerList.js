import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import axios from 'axios';
import { Link } from "react-router-dom";
import { Table, Button } from 'react-bootstrap';

    
const PlayerList = (props) => {
    const { removeFromDom, name } = props;
    const deletePlayer = (playerId) => {
        if (window.confirm(`Are you sure you want to delete ${name}?`)){
            axios.delete('http://localhost:8000/api/player/' + playerId)
                .then(res => {
                    removeFromDom(playerId)
                })
                .catch(err => console.error(err));
        }
    }

    return (
        <div>
            <h1>All player:</h1>
            <Link  to={"/player/new"}>New Player</Link>
            <Table striped bordered hover variant="dark">
                <thead>
                    <tr>
                        <th>Player</th>
                        <th>Position</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {props.player.map( (player, i) =>
                        <tr key={i}>
                            <td>{player.name}</td>
                            <td>{player.position}</td>
                            <td>
                            <Button onClick={(e)=>{deletePlayer(player._id)}}>
                                Delete
                            </Button>
                            <Button href={"/player/" + player._id + "/edit"}>
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
    
export default PlayerList;
