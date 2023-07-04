import {Button, FormControl, Grid, TextField, Box} from "@mui/material";
import { useFormik } from "formik";
import {CoverLetterModel} from "../../../types/models/CoverLetterModel.model";


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
    const formik = useFormik({
        initialValues: initialCoverLetterValues,
        onSubmit: (values) => {
            const coverLetter = values as CoverLetterModel;
            coverLetter.skills = values.skills.split(',');
            coverLetter.weaknesses =values.weaknesses.split(',');
            coverLetter.interests = values.interests.split(',');
        },
    });

    return (
        <Box sx={{ justifyContent: "center", marginLeft: 2, display: "block" }}>
        <form onSubmit={formik.handleSubmit}>
            <Grid container spacing={1}>
                <Grid xs={12}>
                    <h1>
                        Create cover letter
                    </h1>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.name} label="Name" name="name" onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.surname} label="Surname" name="surname" onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField
                            type="number"
                            value={formik.values.age}
                            label="Age" name="age"  onChange={formik.handleChange}
                        ></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.appliedCompany} label="Applying company" name="appliedCompany"  onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.position}  label="Applying position" name="position"  onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.currentEducationLevel} label="Education level" name="currentEducationLevel"  onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.skills} label="Skills" name="skills"  onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.interests} label="Interests" name="interests"  onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12} sx={{marginBottom: 3}}>
                    <FormControl>
                        <TextField value={formik.values.weaknesses} label="Weaknesses" name="weaknesses"  onChange={formik.handleChange}></TextField>
                    </FormControl>
                </Grid>
                <Button type="submit" variant="contained" size="large">Submit</Button>
            </Grid>
        </form>
        </Box>
    );
};

export default CoverLetter;
