import {Box, Button} from "@mui/material";
import {useNavigate} from "react-router-dom";

const CoverLetter = ({decodedObject}: any) => {
    const navigate = useNavigate();
    const content = decodedObject.choices[0].message.content;

    return (
        <>
            <Box sx={{backgroundColor: "white", borderRadius: "3%", padding: 4}}>
                <Button variant="contained" size="small" onClick={() => navigate("/")} sx={{ float: "right",padding: 1, marginTop: 0}} >Download?</Button>
                <p style={{marginTop: "3rem"}}>{content}</p>
            </Box>
            <div style={{display: "flex", justifyContent: "flex-start", marginTop: "2rem"}}>
                <Button variant="contained" size="large" onClick={() => navigate("/")}>Back to start</Button>
            </div>
        </>
    );
};

export default CoverLetter;
