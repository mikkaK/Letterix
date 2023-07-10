import {Box} from "@mui/material";
import {useNavigate} from "react-router-dom";


const GeneralBox = ({content , title}: any) => {
    return (
        <Box sx={{ justifyContent: "center", marginTop: 10, marginLeft: 45, width: "60%", padding: 5, border: "2px solid transparent",
            borderRadius: "3%",
            boxShadow: "0 2px 4px rgba(0, 0, 0, 0.2)", justifySelf:"center",
            background: "linear-gradient(70deg, #F1F9E8, #D6FEFD)"}}>
            <div>
                <h1 style={{color: "#05386B"}}>
                    {title}
                </h1>
                    {content}

            </div>
        </Box>
    );
};

export default GeneralBox;
