import {Button, FormControl, Grid, TextField, Box} from "@mui/material";
import { useFormik } from "formik";
import {CoverLetterModel} from "../../../types/models/CoverLetterModel.model";
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

    const formik = useFormik({
        initialValues: initialCoverLetterValues,
        onSubmit: (values) => {
            const coverLetter = values as CoverLetterModel;
            coverLetter.skills = values.skills.split(',');
            coverLetter.weaknesses =values.weaknesses.split(',');
            coverLetter.interests = values.interests.split(',');
            navigate("/generatedCoverLetter");
        },
    });

    return (
        <Box sx={{ justifyContent: "center", marginTop: 10, marginLeft: 45, width: "60%", padding: 5, border: "2px solid transparent",
            borderRadius: "3%",
            boxShadow: "0 2px 4px rgba(0, 0, 0, 0.2)", justifySelf:"center",
            background: "linear-gradient(70deg, #F1F9E8, #D6FEFD)"}}>
        <form onSubmit={formik.handleSubmit}>
            <h1 style={{color: "#05386B"}}>
                Create cover letter
            </h1>
            <Grid container sx={{backgroundColor: "white", borderRadius: "3%", padding: 5}}>
                        <Grid item xs={3} sx={{marginBottom: 5}}>
                            <h3>Your Details</h3>
                        </Grid>
                        <Grid item xs={3} sx={{marginBottom: 5}}>
                            <FormControl>
                                <TextField value={formik.values.name} label="Name" name="name" onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3} >
                            <FormControl>
                                <TextField value={formik.values.surname} label="Surname" name="surname" onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3} >
                            <FormControl>
                                <TextField
                                    type="number"
                                    value={formik.values.age}
                                    label="Age" name="age"  onChange={formik.handleChange}
                                ></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3} sx={{marginBottom: 5}}>
                            <h3>Your character</h3>
                        </Grid>
                        <Grid item xs={3} sx={{marginBottom: 5}}>
                            <FormControl>
                                <TextField value={formik.values.skills} label="Skills" name="skills"  onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3}>
                            <FormControl>
                                <TextField value={formik.values.interests} label="Interests" name="interests"  onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3}>
                            <FormControl>
                                <TextField value={formik.values.weaknesses} label="Weaknesses" name="weaknesses"  onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3} sx={{marginBottom: 5}}>
                            <h3>Your future</h3>
                        </Grid>
                        <Grid item xs={3} sx={{marginBottom: 5}}>
                            <FormControl>
                                <TextField value={formik.values.appliedCompany} label="Applying company" name="appliedCompany"  onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3} >
                            <FormControl>
                                <TextField value={formik.values.position}  label="Applying position" name="position"  onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={3} >
                            <FormControl>
                                <TextField value={formik.values.currentEducationLevel} label="Education level" name="currentEducationLevel"  onChange={formik.handleChange}></TextField>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12} sx={{display: "flex", justifyContent: "flex-end"}}>
                            <Button type="submit" variant="contained" size="large">Submit</Button>
                        </Grid>
                </Grid>
        </form>
        </Box>
    );
};

export default CoverLetter;
