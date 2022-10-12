import {Box, Button, Center, HStack, Spacer, VStack} from "@chakra-ui/react";


export default function CustomerPage(){
    return (

            <VStack style={{
                position: 'absolute', left: '50%', top: '50%',
                transform: 'translate(-50%, -50%)'
            }}>
                <Box bg={'lightskyblue'} borderRadius={'2xl'} p={4}>

                    <VStack>
                        <HStack width={'auto'}>
                            <label>Account ID</label>
                            <input type={'text'} style={{background: "lightgreen"}}></input>
                        </HStack>
                        <HStack>
                            <label>Password</label>
                            <input type={'text'} style={{background: "lightgreen"}}></input>
                        </HStack>
                        <HStack>
                            <label>Amount</label>
                            <input type={'text'} style={{background: "lightgreen"}}></input>
                        </HStack>
                        <Button>Deposit</Button>
                        <Button>Withdraw</Button>
                    </VStack>

                </Box>
            </VStack>

    )
}