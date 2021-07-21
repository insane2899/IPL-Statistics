import { React,useEffect,useState } from 'react';
import {MatchDetailCard} from '../components/MatchDetailCard';
import {MatchSmallCard} from '../components/MatchSmallCard';
import {TeamTile} from '../components/TeamTile';
import {useParams,Link} from 'react-router-dom';
import { PieChart } from 'react-minimal-pie-chart';
import '../styles/HomePage.scss';

export const HomePage = () => {

  const [teams,setTeam] = useState([]);

  useEffect(
    () => {
        const fetchAllTeams = async () => {
          const response = await fetch(`http://localhost:8080/team`);
          const data = await response.json();
          setTeam(data);
        };
        fetchAllTeams();
    },[]
  );

  return (
    <div className = "HomePage">
      <div className = "header-section">
        <h1 className="app-name">IPL Statistics</h1>
      </div>
      <div className="team-grid">
        {
          teams.map(team =>
            <TeamTile teamName={team.teamName} />
          )
        }
      </div>
    </div>
  );
}
