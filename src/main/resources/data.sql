insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (213014728560001, 'nome fantasia 2002', 'razaon social 2002', 'PessoaJuridica');
insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (212124728560001, 'nome fantasia 2003', 'razaon social 2003', 'PessoaJuridica');
insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (214214728560001, 'nome fantasia 2004', 'razaon social 2004', 'PessoaJuridica');
insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (215314728560001, 'nome fantasia 2005', 'razaon social 2005', 'PessoaJuridica');
insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (216414728560001, 'nome fantasia 2006', 'razaon social 2006', 'PessoaJuridica');
insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (217514728560001, 'nome fantasia 2007', 'razaon social 2007', 'PessoaJuridica');
insert into pessoa (CPF_CNPJ, nome_fantasia, nome, dtype) values (218614728560001, 'nome fantasia 2008', 'razaon social 2008', 'PessoaJuridica');


insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23603472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23604472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23605472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23606472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23607472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23608472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23609472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');
insert into pessoa (dtype, CPF_CNPJ, data_nascimento, nome) values ('PessoaFisica', 23600472856, '1976-03-17 00:00:00', 'carlos jose ramos miguel');


insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-01 00:00:00', 'conta20001', 1000000, null, 23603472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-02 00:00:00', 'conta20002', 1000000, 'conta20001', 23604472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-03 00:00:00', 'conta20003', 1000000, 'conta20001', 23605472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-04 00:00:00', 'conta20004', 1000000, 'conta20001', 23605472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-05 00:00:00', 'conta20005', 1000000, 'conta20002', 23605472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-06 00:00:00', 'conta20006', 1000000, 'conta20002', 23605472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-07 00:00:00', 'conta20007', 1000000, 'conta20005', 23605472856);
insert into conta (data_criacao, nome, saldo, conta_nome, pessoa_cpf_Cnpj) values ('2018-01-08 00:00:00', 'conta20008', 1000000, 'conta20005', 23603472856);
