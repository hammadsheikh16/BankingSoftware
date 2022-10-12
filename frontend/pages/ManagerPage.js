import {Button, Center, Grid, GridItem, HStack, Table, Tbody, Td, Tfoot, Th, Thead, Tr, VStack} from "@chakra-ui/react";


export default function ManagerPage(){
    return (
        <>
            <Grid
                templateRows={'repeat(1, 1fr)'}
                templateColumns={'repeat(3, 1fr)'}
                gap={5}
                padding={5}
                h={'30vh'}>

                <Center>
                    <GridItem rowSpan={1}>Customer Accounts</GridItem>
                </Center>
                <GridItem colSpan={2}>
                    <Table variant={'striped'} colorScheme={'teal'}>
                        <Thead>
                            <Tr>
                                <Th>Account ID</Th>
                                <Th>Balance</Th>
                            </Tr>
                        </Thead>

                        <Tbody>
                            <Tr>
                                <Td>someID</Td>
                                <Td>1247981247</Td>
                            </Tr>
                            {/*    Every entry will be in Tr tags with
                       2 corresponding Td tags for both pieces of data*/}
                        </Tbody>

                        <Tfoot>
                            <Tr>
                                <Th>Account ID</Th>
                                <Th>Balance</Th>
                            </Tr>
                        </Tfoot>
                    </Table>
                </GridItem>
            </Grid>
            <VStack>
                <HStack>
                    <label>Password</label>
                    <input type={'password'}></input>
                </HStack>
                <HStack>
                    <label>Balance</label>
                    <input type={'number'}></input>
                </HStack>
            </VStack>
            <Center p={5}>
                <Button color={'teal'}>Create Account</Button>
                <Button color={'red'}>Delete Account</Button>
            </Center>

            <Grid
                templateRows={'repeat(1, 1fr)'}
                templateColumns={'repeat(3, 1fr)'}
                gap={5}
                padding={5}
                h={'30vh'}>

                <Center>
                    <GridItem rowSpan={1}>Employee Accounts</GridItem>
                </Center>
                <GridItem colSpan={2}>
                    <Table variant={'striped'} colorScheme={'teal'}>
                        <Thead>
                            <Tr>
                                <Th>Username</Th>
                                <Th>Password</Th>
                            </Tr>
                        </Thead>

                        <Tbody>
                            <Tr>
                                <Td>someUsername</Td>
                                <Td>somePassword</Td>
                            </Tr>
                            {/*    Every entry will be in Tr tags with
                       2 corresponding Td tags for both pieces of data*/}
                        </Tbody>

                        <Tfoot>
                            <Tr>
                                <Th>Account ID</Th>
                                <Th>Balance</Th>
                            </Tr>
                        </Tfoot>
                    </Table>
                </GridItem>
            </Grid>
            <VStack>
                <HStack>
                    <label>Username</label>
                    <input type={'password'}></input>
                </HStack>
                <HStack>
                    <label>Password</label>
                    <input type={'number'}></input>
                </HStack>
            </VStack>
            <Center p={5}>
                <Button color={'teal'}>Create Account</Button>
                <Button color={'red'}>Delete Account</Button>
            </Center>
        </>
    )
}