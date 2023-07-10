import {Box, Button, Grid} from "@mui/material";
import {useNavigate} from "react-router-dom";

export const initialCoverLetterValues: any = {
    id: '',
    name: '',
    surname: '',
    age: '',
    appliedCompany: '',
    position: '',
    currentEducationLevel: '',
    skills: '',
    interests: '',
    weaknesses: '',
};

const CoverLetter = () => {
    const navigate = useNavigate();

    return (
        <Box sx={{ justifyContent: "center", marginTop: 10, marginLeft: 45, width: "60%", padding: 5, border: "2px solid transparent",
            borderRadius: "3%",
            boxShadow: "0 2px 4px rgba(0, 0, 0, 0.2)", justifySelf:"center",
            background: "linear-gradient(70deg, #F1F9E8, #D6FEFD)"}}>
            <div>
                <h1 style={{color: "#05386B"}}>
                    Your cover letter
                </h1>
                <Box sx={{backgroundColor: "white", borderRadius: "3%", padding: 5}}>
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,
                        molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum
                        numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium
                        optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis
                        obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam
                        nihil, eveniet aliquid culpa officia aut! Impedit sit sunt quaerat, odit,
                        tenetur error, harum nesciunt ipsum debitis quas aliquid. Reprehenderit,
                        quia. Quo neque error repudiandae fuga? Ipsa laudantium molestias eos
                        sapiente officiis modi at sunt excepturi expedita sint? Sed quibusdam
                        recusandae alias error harum maxime adipisci amet laborum. Perspiciatis
                        minima nesciunt dolorem! Officiis iure rerum voluptates a cumque velit
                        quibusdam sed amet tempora. Sit laborum ab, eius fugit doloribus tenetur
                        fugiat, temporibus enim commodi iusto libero magni deleniti quod quam
                        consequuntur! Commodi minima excepturi repudiandae velit hic maxime
                        doloremque. Quaerat provident commodi consectetur veniam similique ad
                        earum omnis ipsum saepe, voluptas, hic voluptates pariatur est explicabo
                        fugiat, dolorum eligendi quam cupiditate excepturi mollitia maiores labore
                        suscipit quas? Nulla, placeat. Voluptatem quaerat non architecto ab laudantium
                        modi minima sunt esse temporibus sint culpa, recusandae aliquam numquam
                        totam ratione voluptas quod exercitationem fuga. Possimus quis earum veniam
                        quasi aliquam eligendi, placeat qui corporis!
                    </p>
                </Box>
                <div style={{display: "flex", justifyContent: "flex-end", marginTop: "2rem"}}>
                    <Button variant="contained" size="large" onClick={() => navigate("/")}>Back to start</Button>
                </div>
            </div>
        </Box>
    );
};

export default CoverLetter;
