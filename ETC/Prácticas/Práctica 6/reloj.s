                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_horas:      .asciiz "\n   Horas: "
cad_minutos:    .asciiz " Minutos: "
cad_segundos:   .asciiz " Segundos: "
cad_reloj_en_s: .asciiz "\n   Reloj en segundos: "

                ##########################################################
                # Segmento de c�digo
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $a0, reloj
                li $a1, 0x00150F2D
                jal	    inicializa_reloj				# jump to inicializa_reloj and save position to $ra

                jal imprime_reloj
                li		$a0, 1		# $a0 = 1
                #-----------------------------------------------------------------------------------------
                #Ejercicio de la constante 36
                #jal		const36				# jump to const36 and save position to $ra
                #move 	$a0, $v0		# $a0 = $v0
                #li		$v0, 1 		# $t1 = ç
                #syscall
                #------------------------------------------------------------------------------------------
                #Ejercicio devuelve_reloj_en_s_sd
                #la		$a0, reloj		#
                #jal		devuelve_reloj_en_s_sd
                #move 	$a0, $v0		
                #jal imprime_s
                #-----------------------------------------------------------------------------------------
                #Ejercicio multiplicar const 31
                #li		$a0, 31		# $a0 = 1
                #jal		const31				# jump to const31 and save position to $ra
                #move 	$a0, $v0		# $a0 = $v0
                #li		$v0, 1		# $a0 = 1
                #syscall
                #---------------------------------------------------------------------------------------------
                #Ejercicio devuelve_reloj_en_s_srd
                #la $a0, reloj
                #jal		devuelve_reloj_en_s_srd				# jump to devuelve_reloj_en_s_srd and save position to $ra
                #move 	$a0, $v0		# $a0 = $v0
                #jal		imprime_s				# jump to target and save position to $ra
                #--------------------------------------------------------------------------------------------
                #Ejercicio pasa_hora.
                #la $a0, reloj
                #jal		pasa_segundos				# jump to pasa_segundo and save position to $ra
                #jal		imprime_reloj				# jump to imprime_reloj and save position to $ra
                #-----------------------------------------------------------------------------------------------
                #Ejercicio incrementar 3 horas y 40 segundos.
                la $a0, reloj
                #Para hacer los incrementos usamos dos bucles, uno de 3 pasadas y otro de 40
                li		$t8, 1		# $a1 = 1
                li		$t9, 3		# $a2 = 3               
hora:           jal		pasa_hora				# jump to pasa_hora and save position to $ra
                addi	$t8, $t8, 1			# $a1 = $a1 + 1
                ble		$t8, $t9, hora	# if $a1 == $a2 then goto target

                li		$t8, 1		# $a1 = 1
                li		$t9, 40		# $a2 = 40 
 sec:           jal		pasa_segundos				# jump to pasa_segundo and save position to $ra
                addi	$t8, $t8, 1			# $a1 = $a1 + 1
                ble		$t8, $t9, sec	# if $a1 == $a2 then goto target
                jal		imprime_reloj				# jump to imprime_reloj and save position to $ra
                
                

                
             
salir:          li $v0, 10              # C�digo de exit (10)
                syscall                 # �ltima instrucci�n ejecutada
                .end


                ########################################################## 
                # Subrutina que imprime el valor del reloj
                # Entrada: $a0 con la direcci�n de la variable reloj
                ########################################################## 

imprime_reloj:  move $t0, $a0
                la $a0, cad_asteriscos  # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall

                la $a0, cad_horas       # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall

                lbu $a0, 2($t0)         # Lee el campo HH
                li $v0, 1               # C�digo de print_int
                syscall

                la $a0, cad_minutos     # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall

                lbu $a0, 1($t0)         # Lee el campo MM
                li $v0, 1               # C�digo de print_int
                syscall

                la $a0, cad_segundos    # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall

                lbu $a0, 0($t0)         # Lee el campo SS
                li $v0, 1               # C�digo de print_int
                syscall

                la $a0, cad_asteriscos  # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall
                jr $ra

                ########################################################## 
                # Subrutina que imprime los segundos calculados
                # Entrada: $a0 con los segundos a imprimir
                ########################################################## 

imprime_s:      move $t0, $a0
                la $a0, cad_asteriscos  # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall


                la $a0, cad_reloj_en_s  # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall

                move $a0, $t0           # Valor entero a imprimir
                li $v0, 1               # C�digo de print_int
                syscall

                la $a0, cad_asteriscos  # Direcci�n de la cadena
                li $v0, 4               # C�digo de print_string
                syscall
                jr $ra
                
                ########################################################## 
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la direcci�n del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
                
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra

inicializa_reloj:   li		$t1, 0x003f3f3f		# Cargamos el valor para hacer la and
                    and		$t1, $a1, $t1	#Modificamos la hora
                    sw		$t1, 0($a0)		# Guardamos la hora
                    jr		$ra				# jump to $ra
devuelve_reloj_en_s: lb	$t1, 0($a0)		    # segundos
                      lb	$t2, 1($a0)		    # minutos
                      lb	$t3, 2($a0)		    # horas
                      move 	$t5, $ra		    # Salto al main guardado en $t5
                      jal	horas				# jump to horas and save position to $ra
                      jal	minutos				# jump to minutos and save position to $ra
                      add	$v0, $t1, $t2		# $v0 = $t1 + $t2
                      add	$v0, $v0, $t3		# $t0 = $t1 + $t2
                      j		$t5					# jump to $ra
                    
                    
                   
horas:              li		$t4, 3600 		# $t4 = 3600
                    mult	$t3, $t4			# $t3 * $t4 = Hi and Lo registers
                    mflo	$t3					# copy Lo to $t2
                    jr		$ra					# jump to $ra
                    
minutos:            li		$t4, 60		# $t4 = 60
                    mult	$t2, $t4			# $t2 * $t4 = Hi and Lo registers
                    mflo	$t2					# copy Lo to $t2
                    jr		$ra					# jump to $ra

const36:            sll		$v0, $a0, 5			
                    sll		$t0, $a0, 2			
                    addu    $v0, $v0, $t0
                    jr		$ra					# jump to $ra

devuelve_reloj_en_s_sd:
                    lbu		$t0, 0($a0)		# Cargamos los segundos.                                                                   #3600 = 11,10,9,4
                    lbu		$t1, 1($a0)		# Cargamos los minutos.                                                                    #60 = 5,4,3,2
                    lbu		$t2, 2($a0)		# Cargamos las horas.
                    #convertimos las horas a minutos.
                    sll		$t3, $t2, 11	
                    sll		$t4, $t2, 10	
                    addu    $t5, $t4, $t3
                    sll		$t3, $t2, 9
                    addu    $t5, $t3, $t5
                    sll		$t3, $t2, 4			
                    addu    $t2,$t3,$t5 #horas en segundos
                    #minutos pasados a segundo
                    sll		$t3, $t1, 5			
                    sll		$t4, $t1, 4			
                    addu    $t5, $t4, $t3
                    sll		$t3, $t1, 3
                    addu    $t5, $t3, $t5
                    sll     $t3, $t1, 2
                    addu    $t5, $t3, $t5 
                    move 	$t1, $t5		#Minutos pasados a segundos
                    #sumarlo todo
                    addu    $v0, $t0, $t1
                    addu    $v0, $v0, $t2
                    jr		$ra					# jump to $ra

const31:            sll		$v0, $a0, 5		#31 = 10000-1
                    subu     $v0, $v0, $a0 
                    jr		$ra					# jump to $ra

devuelve_reloj_en_s_srd:
                    lb		$t0, 0($a0)	#Cargamos los segundos
                    lb		$t1, 1($a0)	#Cargamos los minutos
                    lb		$t2, 2($a0)	#Cargamos las horas	
                    #Horas a segundos 3600 = 12,-9, 5, -4
                    sll		$t3, $t2, 12 # $t3 = $t1 << 0
                    sll		$t4, $t2, 9			# $t4 = $t2 <9 0
                    subu    $t5, $t3,$t4
                    sll		$t3, $t2, 5			# $t3 = $2 << 5
                    addu    $t5, $t5, $t3
                    sll		$t3, $t2, 4			# $t3 = $t2 << 4
                    subu    $t5, $t5, $t3
                    move 	$t2, $t5		
                    #Minutos a segundos 60 6,-2
                    sll		$t3, $t1, 6			# $t3 = $t1 << 6
                    sll		$t4, $t1, 2			# $t4 = $t1 << 2
                    subu    $t5, $t3, $t4
                    move 	$t1, $t5		# $t1 = $t5
                    #Sumamos todo
                    addu    $v0, $t0, $t1
                    addu    $v0, $v0, $t2
                  
                    jr		$ra					# jump to $ra

pasa_segundos:      lb		$t0, 0($a0)		# Cargamos los segundos
                    addi	$t0, $t0, 1		#Sumamos un segundo
                    li		$t4, 60		# $t1 = 60
                    bge		$t0, $t4, pasa_minutos	# if $t0 >= $t1 then goto pasa_minutos 
                    sb		$t0, 0($a0)		# 
                    
return_main:        jr		$ra					# jump to $ra

pasa_minutos:       li		$t0, 0		# $t0 = 0
                    sb		$t0, 0($a0)		# 
                    
                    lb		$t3, 1($a0)		# Cargamos los minutos.
                    addi	$t3, $t3, 1			# $t1 = $t1 + 1
                    bge		$t3, $t4, cero_minutos	# if $t1 >= $t3 then goto target
                    sb		$t3, 1($a0)		# 
                    
                    j		return_main				# jump to return_main

cero_minutos:       sb		$t0, 1($a0)		# 
                    j		pasa_hora				# jump to pasa_horas
                    
                    

                    
                    
                    
                    

                    
                            
                    


                    
                    
                    
                    
                    
                    
                    
                  
                    
